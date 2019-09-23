package com.tyzn.NettyService.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 喷洒表,默认喷洒一分钟
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Spray {
    //1控制开关 ，2获取数据
    private Integer cmd = 1;

    //喷洒状态，0关闭，1开启
    private Integer status = 1;

    //喷洒时间，默认一分钟，，，喷洒分钟数最大值65535
    private Integer time = 1;
}
