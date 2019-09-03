package com.tyzn.NettyService.service.impl;

import com.tyzn.NettyService.Utils.ByteBufUtil;
import com.tyzn.NettyService.service.ISendService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;

public class SendServiceImpl implements ISendService {

    /**
     * 收到publish消息。
     */
    @Override
    public void receivePublish(Channel channel, MqttPublishMessage message) {
        MqttFixedHeader fixedHeader = message.fixedHeader();
        MqttPublishVariableHeader variableHeader = message.variableHeader();
        ByteBuf payload = message.payload();
        byte[] bytes = ByteBufUtil.copyByteBuf(payload);
        int messageId = variableHeader.messageId();
        //判断是什么设备消息，处理....
        //逻辑代码
        switch (fixedHeader.qosLevel()) {
            case AT_MOST_ONCE: // 至多一次,不需要处理。
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
}
