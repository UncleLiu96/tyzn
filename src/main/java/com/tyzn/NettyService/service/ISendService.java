package com.tyzn.NettyService.service;

import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.MqttPublishMessage;

public interface ISendService {
    void receivePublish(Channel channel, MqttPublishMessage message);
}
