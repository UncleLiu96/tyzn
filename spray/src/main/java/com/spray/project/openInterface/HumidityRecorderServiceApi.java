package com.spray.project.openInterface;

import com.alibaba.fastjson.JSONObject;
import com.spray.project.recorder.domain.HumidityRecorder;
import com.spray.project.recorder.service.IHumidityRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/26 0026 14:24
 * @desc TODO
 */

@RestController
@RequestMapping("api")
public class HumidityRecorderServiceApi {

    @Autowired
    private IHumidityRecorderService recorderService;

    /**
     * 保存湿度记录
     * @param devId
     * @param hum
     * @return
     */
    @PostMapping("addHumidityRecorder")
    public int addHumidityRecorder(String devId,double hum) {
        HumidityRecorder recorder = new HumidityRecorder();
        recorder.setDeviceNumber(devId);
        recorder.setHumidity(hum);
        return recorderService.insertHumidityRecorder(recorder);
    }


}
