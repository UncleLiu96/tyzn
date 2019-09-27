package com.spray.project.job.task;

import com.alibaba.fastjson.JSONObject;
import com.common.Utils.Constants;
import com.common.Utils.http.HttpUtils;
import com.common.annotation.Log;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import org.springframework.stereotype.Component;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/26 0026 11:41
 * @desc TODO 电磁阀设备定时任务
 */
@Component
public class RadiotubeDeviceTask {

    /**
     * 电磁阀启动任务
     * @param params
     */
    @Log(detail ="RadiotubeDeviceTask执行电磁阀设备启动任务",level = 5,operationType = OperationType.UNKNOWN,operationUnit = OperationUnit.UNKNOWN)
    public void deviceOpen(String params){
        JSONObject jsonObject = new JSONObject();
        //截取设备编号
        String[] split = params.split(",");
        for(int i = 0 ; i < split.length ; i++){
            //调用启动设备业务方法
            jsonObject.put("clientId",split[i]);//设备编号
            jsonObject.put("minute",1);//开启时长 分钟
            //调用开启设备方法
            HttpUtils.httpPostWithForm(Constants.MQTT_URL+"api/openDevice",jsonObject);

        }
    }

}
