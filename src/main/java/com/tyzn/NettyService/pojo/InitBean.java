package com.tyzn.NettyService.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "tyzn.server")
@Data
public class InitBean {

    //private ProtocolEnum protocol;

    /*服务端口*/
    private int port ;

    /*服务名称*/
    private String serverName ;

    /*是否保持连接，是否开启心跳*/
    private boolean keepalive ;

    /*地址复用*/
    private boolean reuseaddr ;

    /*立即发送数据*/
    private boolean tcpNodelay ;

    /*服务端接受连接的队列长度*/
    private int backlog ;

    /*TCP数据发送缓冲区大小*/
    private  int  sndbuf ;

    /*TCP数据接收缓冲区大小*/
    private int revbuf ;

    /*读超时时间*/
    private int heart ;

    /*使用ssl加密*/
    private boolean ssl ;

    /* ssl 加密 jks文件地址*/
    private String jksFile;

    /*jks密码*/
    private String jksStorePassword;

    /*读取私钥密码*/
    private String jksCertificatePassword;

    /* MQTT 默认处理，默认hander类*/
    //private Class<MqttHander> mqttHander ;

    /*mqtt qos1 qos2 消息 重发延迟*/
    private int  initalDelay ;

    /*mqtt qos1 qos2 消息 重发周期*/
    private  int period ;

    /*boss线程*/
    private int bossThread;

    /*work线程*/
    private int workThread;

}
