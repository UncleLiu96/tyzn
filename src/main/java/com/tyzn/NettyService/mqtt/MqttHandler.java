package com.tyzn.NettyService.mqtt;

import com.tyzn.NettyService.enums.SessionStatus;
import com.tyzn.NettyService.pojo.MqttChannel;
import com.tyzn.NettyService.service.ILoginService;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.*;
import io.netty.util.AttributeKey;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *  Mqtt消息功能类
 */
@Component
public class MqttHandler {

    @Autowired
    ILoginService iLoginService;

    public boolean login(Channel channel, MqttConnectMessage message){
        MqttConnectPayload payload = message.payload();
        String clientId = payload.clientIdentifier();
        MqttConnectVariableHeader variableHeader = message.variableHeader();
        if(StringUtil.isNullOrEmpty(clientId)){
            //客户端ID为空，返回对应报文
            connack(channel,MqttConnectReturnCode.CONNECTION_REFUSED_IDENTIFIER_REJECTED);
            return false;
        }
        if(variableHeader.hasUserName() && variableHeader.hasPassword()
           && !iLoginService.checkClient(payload.userName(),payload.passwordInBytes().toString())){
            //用户名密码校验不通过
            connack(channel,MqttConnectReturnCode.CONNECTION_REFUSED_BAD_USER_NAME_OR_PASSWORD);
            return false;
        }

        MqttChannel mqttChannel = MqttChannel.builder().
                deviceId(clientId)
                .sessionStatus(SessionStatus.ONLINE)
                .build();
        new MqttChannelMaps().addMqttChannel(clientId,mqttChannel);

        ChannelMap map = new ChannelMap();
        map.addChannel(clientId,channel);


        AttributeKey<String> _clientId = AttributeKey.valueOf("clientId");
        AttributeKey<Boolean> _login = AttributeKey.valueOf("login");
        channel.attr(_login).set(true);
        channel.attr(_clientId).set(clientId);

        connack(channel,MqttConnectReturnCode.CONNECTION_ACCEPTED);
        return true;
    }

    /**
     * 连接确认报文
     * @param channel
     * @param code
     */
    public void connack(Channel channel, MqttConnectReturnCode code){
        MqttFixedHeader fixedHeader = new MqttFixedHeader(MqttMessageType.CONNACK,false,MqttQoS.AT_MOST_ONCE,false,0x02);
        MqttConnAckVariableHeader variableHeader = new MqttConnAckVariableHeader(code,false);
        MqttConnAckMessage message = new MqttConnAckMessage(fixedHeader,variableHeader);
        channel.writeAndFlush(message);
    }

    /**
     * 发送Qos 0  的消息
     * @param channel
     * @param topic
     * @param byteBuf
     * @param messageId
     */
    public void sendQos0Msg(Channel channel, String topic, byte[] byteBuf,int messageId){
        MqttFixedHeader mqttFixedHeader = new MqttFixedHeader(MqttMessageType.PUBLISH,false, MqttQoS.AT_MOST_ONCE,false,0);
        MqttPublishVariableHeader mqttPublishVariableHeader = new MqttPublishVariableHeader(topic,messageId );
        MqttPublishMessage mqttPublishMessage = new MqttPublishMessage(mqttFixedHeader,mqttPublishVariableHeader, Unpooled.wrappedBuffer(byteBuf));
        channel.writeAndFlush(mqttPublishMessage);
    }


}
