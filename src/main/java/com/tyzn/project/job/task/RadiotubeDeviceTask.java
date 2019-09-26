package com.tyzn.project.job.task;

import com.common.annotation.Log;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.tyzn.NettyService.service.IDeviceHandelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/26 0026 11:41
 * @desc TODO 电磁阀设备定时任务
 */
@Component
public class RadiotubeDeviceTask {

    @Autowired
    private IDeviceHandelService iDeviceHandelService;//设备操作

    /**
     * 电磁阀启动任务
     * @param params
     */
    @Log(detail ="RadiotubeDeviceTask执行电磁阀设备启动任务",level = 5,operationType = OperationType.UNKNOWN,operationUnit = OperationUnit.UNKNOWN)
    public void deviceOpen(String params){
        //截取设备编号
        String[] split = params.split(",");
        for(int i = 0 ; i < split.length ; i++){
            //调用启动设备业务方法
            iDeviceHandelService.openDevice(split[i],1);//启动设备，时长1分钟
        }
    }

}
