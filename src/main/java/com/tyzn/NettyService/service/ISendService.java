package com.tyzn.NettyService.service;

import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttSubscribeMessage;
import io.netty.handler.codec.mqtt.MqttUnsubscribeMessage;

public interface ISendService {
    void receivePublish(Channel channel, MqttPublishMessage message);

    void receivePing(Channel channel);

    void closeConnect(String clientId);

    void receivePuback(Channel channel);

    void receiveSubscribe(Channel channel, MqttSubscribeMessage message,String clientId);

    void receiveUnSubscribe(Channel channel, MqttUnsubscribeMessage message, String clientId);

    void closeChannel(Channel channel,String clientId);

    void send2ClientQos0(Channel channel,String clientId,String msg);

    void pushTopic(String topic,String msg);
}

