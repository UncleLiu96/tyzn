package com.tyzn.project.job.task;

import com.common.annotation.Log;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.tyzn.NettyService.Utils.JsonUtils;
import com.tyzn.NettyService.enums.SessionStatus;
import com.tyzn.NettyService.mqtt.ChannelMap;
import com.tyzn.NettyService.mqtt.MqttChannelMaps;
import com.tyzn.NettyService.pojo.MqttChannel;
import com.tyzn.NettyService.pojo.Spray;
import com.tyzn.NettyService.service.ISendService;
import io.netty.handler.codec.mqtt.MqttQoS;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/21 0021 9:40
 * @desc TODO MqttService定时任务
 */
@Component
public class MqttServiceTask {

    @Autowired
    ISendService sendService;

    /**
     * 每小时执行一 次，拉取湿度数据
    * @Author: Uncle liu
    * @Param: [ null]
    * @return: null
    * @Date: 2019-09-21 09:53
    */
    @Scheduled(cron="0 0 0/1 * * ? ")   //    0/10 * * * * ?   10秒执行一次        0 0 0/1 * * ?  一小时执行一次
    @Log(detail ="MqttServiceTask执行设备启动任务",level = 5,operationType = OperationType.UNKNOWN,operationUnit = OperationUnit.UNKNOWN)
    public void timedGetData(){
        //一小时执行一次，定时检测拉取数据
        Collection<MqttChannel> channels = MqttChannelMaps.getMqttChannelMaps().values();
        channels.parallelStream().forEach(mqttChannel -> {
            if(mqttChannel.getSessionStatus().equals(SessionStatus.ONLINE)) {
                Spray spray = new Spray(2,1,1);
                sendService.send2Client(ChannelMap.getChannel(mqttChannel.getDeviceId()),mqttChannel.getDeviceId(), JsonUtils.Obj2JsonStr(spray),MqttQoS.AT_LEAST_ONCE);
            }
        });
    }
}
