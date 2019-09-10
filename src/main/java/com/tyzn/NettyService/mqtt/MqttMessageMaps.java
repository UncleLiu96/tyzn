package com.tyzn.NettyService.mqtt;

import com.tyzn.NettyService.pojo.MqttChannel;
import io.netty.handler.codec.mqtt.MqttMessage;

import java.util.concurrent.ConcurrentHashMap;

public class MqttMessageMaps {

    private static ConcurrentHashMap<Integer, MqttMessage> mqttMessages = new ConcurrentHashMap<>();

    public static MqttMessage getMqttMessage(Integer id){
        return mqttMessages.get(id);
    }

    public static void removeMqttMessage(Integer id){
        mqttMessages.remove(id);
    }

    public static void setMqttMessages(Integer id,MqttMessage message){mqttMessages.put(id,message);}
}
