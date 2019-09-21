package com.tyzn.project.job.task;

import com.common.annotation.Log;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.tyzn.project.job.service.ISysJobPOService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/9 0009 14:46
 * @desc TODO 设备启动/关闭定时任务
 */
@Component("equipmentTask")
public class EquipmentTask {
    @Resource
    private ISysJobPOService iSysJobPOService;

    /**
     * 设备启动任务
     * @param params 设备编号拼接 id,id,id
     */
    @Log(detail ="EquipmentTask执行设备启动任务",level = 5,operationType = OperationType.UNKNOWN,operationUnit = OperationUnit.UNKNOWN)
    public void deviceStart(String params){
        //截取设备编号
        String[] split = params.split(",");
        for(int i = 0 ; i < split.length ; i++){
            //调用启动设备业务方法
            System.out.println("调用启动设备业务方法"+split[i]);
        }

    }

    /**
     * 设备关闭任务
     * @param params 设备编号拼接 id,id,id
     */
    @Log(detail ="EquipmentTask执行设备关闭任务",level = 5,operationType = OperationType.UNKNOWN,operationUnit = OperationUnit.UNKNOWN)
    public void deviceClose(String params){
        //截取设备编号
        String[] split = params.split(",");
        for(int i = 0 ; i < split.length ; i++){
            //调用启动设备业务方法
            System.out.println("调用关闭设备业务方法"+split[i]);
        }
    }







}
