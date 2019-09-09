package com.tyzn.NettyService.Handler;

import com.tyzn.NettyService.mqtt.MqttChannelMaps;
import com.tyzn.NettyService.mqtt.MqttHandler;
import com.tyzn.NettyService.pojo.MqttChannel;
import com.tyzn.NettyService.service.ISendService;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.mqtt.*;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 通信处理类，处理连接，断开，接收消息，心跳，异常等。
 */
@Slf4j
@Component
public class DefaultHandler extends SimpleChannelInboundHandler<MqttMessage> {

    public static DefaultHandler defaultHandler;

    @Autowired
    MqttHandler mqttHandler;

    @Autowired
    ISendService sendService;

    protected AttributeKey<String> _clientId = AttributeKey.valueOf("clientId");

    public DefaultHandler(){

    }

    /**
     * 解决无法注入问题
     */
    @PostConstruct
    public void init(){
        defaultHandler = this;
        defaultHandler.mqttHandler = this.mqttHandler;
        defaultHandler.sendService = this.sendService;
    }

    /**
     *
     * @param ctx
     * @param cause
     * @throws Exception
     * 出现异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //出现异常，断开连接
        log.info(cause.getMessage()+"，关闭连接！");
        ctx.close();
    }

    /**
     * 心跳超时处理
     * @param ctx
     * @param evt
     * @throws Exception
     * 心跳处理
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            log.info("心跳超时，关闭channel");
            Channel channel = ctx.channel();
            String clientId = channel.attr(_clientId).get();
            switch (e.state()) {
                case READER_IDLE:   //读
                    defaultHandler.sendService.closeChannel(channel,clientId);
                    break;
                case WRITER_IDLE:   //写
                    defaultHandler.sendService.closeChannel(channel,clientId);
                    break;
                case ALL_IDLE:  //读写都有
                    defaultHandler.sendService.closeChannel(channel,clientId);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @param ctx
     * @throws Exception
     * 连接断开处理
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("连接关闭，删除客户端信息");
    }

    /**
     * @param ctx
     * @throws Exception
     * 连接建立处理
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("连接成功，保存客户端信息");
    }

    /**
     * 收到消息处理
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MqttMessage message) throws Exception {
        log.info("收到消息");
        log.info("【" + channelHandlerContext.channel().id() + "】" + " :" + message);
        log.info("消息："+message.decoderResult());
        //channelHandlerContext.writeAndFlush("你好"+channelHandlerContext.channel().id());
        Channel channel = channelHandlerContext.channel();
        MqttFixedHeader fixedHeader = message.fixedHeader();
        //第一步登陆
        if(fixedHeader.messageType().equals(MqttMessageType.CONNECT)){
            if(!defaultHandler.mqttHandler.login(channel,(MqttConnectMessage) message)){
                channel.close();
            }
            return;
        }

        MqttChannel mqttChannel = new MqttChannelMaps().getMqttChannel(channel.attr(_clientId).get());
        String clientId = channel.attr(_clientId).get();
        if(mqttChannel!=null){
            switch (fixedHeader.messageType()){
                case PUBLISH:
                    //收到消息，需要根据消息类型进行相关处理。
                    defaultHandler.sendService.receivePublish(channel,(MqttPublishMessage) message);
                    break;
                case SUBSCRIBE:
                    //订阅主题，回复订阅确认
                    defaultHandler.sendService.receiveSubscribe(channel,(MqttSubscribeMessage) message,clientId);
                    //defaultHandler.sendService.send2ClientQos0(channel,clientId,"发送给灯杆一组");
                    defaultHandler.sendService.pushTopic("lamppost09","发送主题消息测试",MqttQoS.AT_MOST_ONCE);
                    break;
                case PINGREQ:
                    //心跳，回复心跳响应
                    defaultHandler.sendService.receivePing(channel);
                    break;
                case DISCONNECT:
                    //关闭连接请求，无需返回，直接关闭，删除保存的信息。
                    defaultHandler.sendService.closeConnect(clientId);
                    break;
                case UNSUBSCRIBE:
                    //取消订阅，回复确认消息
                    defaultHandler.sendService.receiveUnSubscribe(channel,(MqttUnsubscribeMessage) message,clientId);
                    break;
                case PUBACK:
                    //收到消息确认。
                    //保证能收到消息，但是可能会重复。进行对应的处理。
                    defaultHandler.sendService.receivePuback(channel);
                    break;
                case PUBREC:
                    //暂时不做处理
                    break;
                case PUBREL:
                    //暂时不做处理
                    break;
                case PUBCOMP:
                    //暂时不做处理
                    break;
                default:
                    break;
            }
        }

    }

}
