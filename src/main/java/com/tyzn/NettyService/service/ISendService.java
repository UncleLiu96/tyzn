package com.tyzn.NettyService.service;

import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.*;

public interface ISendService {
    void receivePublish(Channel channel, MqttPublishMessage message);

    void receivePing(Channel channel);

    void closeConnect(String clientId);

    void receivePuback(MqttMessage message);

    void receiveSubscribe(Channel channel, MqttSubscribeMessage message,String clientId);

    void receiveUnSubscribe(Channel channel, MqttUnsubscribeMessage message, String clientId);

    void closeChannel(Channel channel,String clientId);

    void send2ClientQos0(Channel channel,String clientId,String msg);

    void pushTopic(String topic, String msg, MqttQoS qos);

    void receivePubrec(Channel channel,MqttMessage message);

    void receivePubrel(Channel channel,MqttMessage message);

    void receivePubcomp(MqttMessage message);
}

