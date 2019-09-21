package com.tyzn.project.job.task;

import com.common.annotation.Log;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/21 0021 9:40
 * @desc TODO MqttService定时任务
 */
@Component
public class MqttServiceTask {

    /**
     * 每10秒执行一次
    * @Author: Uncle liu
    * @Param: [ null]
    * @return: null
    * @Date: 2019-09-21 09:53
    */
    @Scheduled(cron="0/10 * * * * ? ")
    @Log(detail ="MqttServiceTask执行设备启动任务",level = 5,operationType = OperationType.UNKNOWN,operationUnit = OperationUnit.UNKNOWN)
    public void test(){
        System.out.println(123);
    }
}
