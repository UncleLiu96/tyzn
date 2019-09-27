package com.netty.NettyService.openInterface;

import com.alibaba.fastjson.JSONObject;
import com.netty.NettyService.service.IDeviceHandelService;
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
public class DeviceApi {

    @Autowired
    private IDeviceHandelService iDeviceHandelService;

    /**
     * 开启设备
     *
     * @param clientId
     * @param minute
     */
    @PostMapping("openDevice")
    public void openDevice(String clientId,
                           int minute) {
        System.out.println("netty:" + clientId);
        System.out.println("netty:" + minute);
        iDeviceHandelService.openDevice(clientId, minute);
    }


}
