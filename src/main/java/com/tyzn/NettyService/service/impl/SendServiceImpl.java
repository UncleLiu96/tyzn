package com.tyzn.NettyService.service.impl;

import com.tyzn.NettyService.Utils.ByteBufUtils;
import com.tyzn.NettyService.enums.SessionStatus;
import com.tyzn.NettyService.mqtt.ChannelMap;
import com.tyzn.NettyService.mqtt.MqttChannelMaps;
import com.tyzn.NettyService.mqtt.MqttHandler;
import com.tyzn.NettyService.pojo.MqttChannel;
import com.tyzn.NettyService.service.ISendService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
@Service
public class SendServiceImpl implements ISendService {

    @Autowired
    MqttHandler handler;

    /**
     * 收到publish消息。
     */
    @Override
    public void receivePublish(Channel channel, MqttPublishMessage message) {
        MqttFixedHeader fixedHeader = message.fixedHeader();
        MqttPublishVariableHeader variableHeader = message.variableHeader();
        ByteBuf payload = message.payload();
        int messageId = variableHeader.messageId();
        //判断是什么设备消息，处理....
        //逻辑代码
        switch (fixedHeader.qosLevel()) {
            case AT_MOST_ONCE: // 至多一次,不需要回应。拿到消息直接处理就可以了
                System.out.println("收到QOS 0 的消息:"+ByteBufUtils.convertByteBufToString(payload));
                break;
            case AT_LEAST_ONCE:
                //回复发布确认，响应qos1 等级的消息
                //逻辑代码
                break;
            case EXACTLY_ONCE:
                //回复发布收到，响应qos2 等级的消息
                //逻辑代码
                break;
        }

        //根据消息保留标志进行处理。
        //逻辑代码
    }

    /**
     * 心跳响应，收到心跳进行响应
     * @param channel
     */
    @Override
    public void receivePing(Channel channel){
        handler.pingResp(channel);
    }

    /**
     * 收到关闭连接消息，进行关闭，遗嘱发布，保留回话等操作
     * @param clientId
     */
    @Override
    public void closeConnect(String clientId){
        MqttChannelMaps map = new MqttChannelMaps();
        map.removeMqttChannel(clientId);

        ChannelMap channelMap = new ChannelMap();
        Channel channel = channelMap.getChannel(clientId);
        channel.close();
        channelMap.removeChannel(clientId);
        //保持会话功能省略，默认不保存会话直接删除
        //遗嘱功能省略，默认无遗嘱
    }

    /**
     * 收到消息确认，表示对方收到消息了。
     * @param channel
     */
    @Override
    public void receivePuback(Channel channel){
        //对方收到消息了，正常来说这边要保存发送未完成的消息。待对方收到消息，移除对应的消息,或者标记为已完成
    }

    /**
     * 收到订阅消息，处理之后返回suback消息
     * @param channel
     * @param message
     */
    @Override
    public void receiveSubscribe(Channel channel,MqttSubscribeMessage message,String clientId){
        Set<String> topics = message.payload().topicSubscriptions().stream().map(
                mqttTopicSubscription ->
                mqttTopicSubscription.topicName()
        ).collect(Collectors.toSet());
        MqttChannel mqttChannel = new MqttChannelMaps().getMqttChannel(clientId);
        if(mqttChannel!=null){
            Set<String> mqttTopic = mqttChannel.getTopic()==null ? new HashSet<>() : mqttChannel.getTopic();
            for (String item : topics) {
                mqttTopic.add(item);
                System.out.println("主题"+item);
            }
            mqttChannel.setTopic(mqttTopic);
        }
        handler.suback(channel,message,topics.size());
    }

    /**
     * 收到取消订阅消息，取消列表中订阅的主题
     * @param channel
     * @param message
     * @param clientId
     */
    @Override
    public void receiveUnSubscribe(Channel channel,MqttUnsubscribeMessage message,String clientId){
        List<String> topics = message.payload().topics();
        MqttChannel mqttChannel = new MqttChannelMaps().getMqttChannel(clientId);
        if(mqttChannel!=null) {
            Set<String> mqttTopic = mqttChannel.getTopic();
            for (String item : topics) {
                mqttTopic.remove(item);
            }
            mqttChannel.setTopic(mqttTopic);
        }
        handler.unSuback(channel,message);
    }

    /**
     * 关闭channel ，将状态改为 关闭。
     * @param channel
     * @param clientId
     */
    @Override
    public void closeChannel(Channel channel,String clientId){
        MqttChannel mqttChannel = new MqttChannelMaps().getMqttChannel(clientId);
        mqttChannel.setSessionStatus(SessionStatus.OFFLINE);
        channel.close();
    }

    /**
     * 发送qos0 的消息到指定客户端
     * @param channel
     * @param clientId
     * @param msg
     */
    @Override
    public void send2ClientQos0(Channel channel,String clientId,String msg){
        MqttChannel mqttChannel = new MqttChannelMaps().getMqttChannel(clientId);
        if(mqttChannel.getSessionStatus().equals(SessionStatus.ONLINE)){
            handler.sendQos0Msg(channel,"",msg.getBytes(),mqttChannel.messageId());
        }
    }

    /**
     * 推送消息到指定主题，订阅该主题的客户端都能收到消息
     * @param topic
     * @param msg
     */
    @Override
    public void pushTopic(String topic,String msg,MqttQoS qos){
        Collection<MqttChannel> channels = new MqttChannelMaps().getMqttChannelMaps().values();
        channels.parallelStream().forEach(mqttChannel -> {
            if(mqttChannel.getSessionStatus().equals(SessionStatus.ONLINE)) {
                mqttChannel.getTopic().forEach(topics -> {
                    if (topics.equals(topic)) {
                        switch (qos){
                            case AT_MOST_ONCE:
                                //发送qos0消息
                                handler.sendQosMsg(new ChannelMap().getChannel(mqttChannel.getDeviceId()),topic,msg.getBytes(),mqttChannel.messageId(),qos);
                                break;
                            case AT_LEAST_ONCE:
                                //发送qos1消息，收到回复之前，要存储消息并且标记未完成。
                                break;
                            case EXACTLY_ONCE:
                                //发送qos2消息，收到第一次回复之前，要存储消息并且标记未完成。
                                break;
                            default:
                                //默认发送qos0
                                break;
                        }
                    }
                });
            }
        });
    }

}
