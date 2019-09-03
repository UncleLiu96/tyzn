package com.tyzn.NettyService.Handler;

import com.tyzn.NettyService.Handler.DefaultHandler;
import com.tyzn.NettyService.pojo.InitBean;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.mqtt.MqttDecoder;
import io.netty.handler.codec.mqtt.MqttEncoder;
import io.netty.handler.timeout.IdleStateHandler;

public class InitHandler {

    public void initHandler(ChannelPipeline ch, InitBean initBean) {

        /*编解码方式，后续根据协议，自己定义编解码方式*/
        ch.addLast("MqttDecoder",new MqttDecoder());
        //ch.addLast("MqttEncoder",new MqttEncoder());
        /*心跳设定*/
        ch.addLast(new IdleStateHandler(initBean.getHeart(),0,0));
        /*通信处理类，处理连接，断开，收到信息等处理*/
        ch.addLast(new DefaultHandler());

    }
}
