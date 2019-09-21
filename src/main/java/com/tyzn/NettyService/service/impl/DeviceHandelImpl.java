package com.tyzn.NettyService.service.impl;

import com.tyzn.NettyService.Utils.JsonUtils;
import com.tyzn.NettyService.mqtt.ChannelMap;
import com.tyzn.NettyService.pojo.Spray;
import com.tyzn.NettyService.service.IDeviceHandelService;
import com.tyzn.NettyService.service.ISendService;
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
            Spray spray = new Spray();
            spray.setTime(minute);
            sendService.send2Client(channel,clientId, JsonUtils.Obj2JsonStr(spray), MqttQoS.AT_LEAST_ONCE);
        }else {
            log.error("不存在的Channel....");
        }
    }
}
