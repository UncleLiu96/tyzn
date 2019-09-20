package com.tyzn.NettyService.pojo;

import lombok.Data;

/**
 * 设备状态
 */
@Data
public class DeviceStstus {
    // 1 为开关状态改变   2 为当前湿度状态
    private Integer rep;

    //设备ID
    private String devId;

    //设备状态，0关闭，1打开
    private Integer status;

    //剩余喷洒时间。单位分钟。
    private Integer time;

    //温度，0-100
    private Integer temp;

    //湿度，0-100
    private Integer hum;
}
