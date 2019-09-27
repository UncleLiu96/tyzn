package com.netty.NettyService.service.impl;

import com.netty.NettyService.Utils.JsonUtils;
import com.netty.NettyService.mqtt.ChannelMap;
import com.netty.NettyService.pojo.Spray;
import com.netty.NettyService.service.IDeviceHandelService;
import com.netty.NettyService.service.ISendService;
import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.MqttQoS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DeviceHandelImpl implements IDeviceHandelService {

    @Autowired
    ISendService sendService;

    //操作指定客户端打开水闸
    @Override
    public void openDevice(String clientId,int minute){
        Channel channel = ChannelMap.getChannel(clientId);
        if(channel != null && minute > 0){
            Spray spray = new Spray(1,1,minute);
            sendService.send2Client(channel,clientId, JsonUtils.Obj2JsonStr(spray), MqttQoS.AT_LEAST_ONCE);
        }else {
            log.error("不存在的Channel....");
        }
    }
}
