package com.netty.NettyService.mqtt;

import com.netty.NettyService.pojo.MqttChannel;

import java.util.concurrent.ConcurrentHashMap;

public class MqttChannelMaps {
    private static ConcurrentHashMap<String , MqttChannel> mqttChannels = new ConcurrentHashMap<>();

    public static void addMqttChannel(String id, MqttChannel gateway_channel){
        mqttChannels.put(id, gateway_channel);
    }

    public static ConcurrentHashMap<String, MqttChannel> getMqttChannelMaps(){
        return mqttChannels;
    }

    public static MqttChannel getMqttChannel(String id){
        return mqttChannels.get(id);
    }

    public static void removeMqttChannel(String id){
        mqttChannels.remove(id);
    }
}
