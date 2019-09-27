package com.netty.NettyService.Demo;

import com.netty.NettyService.pojo.MqttChannel;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.mqtt.*;
import java.util.LinkedList;
import java.util.List;

public class MqttDemo {

    /**
     * 连接报文，客户端到服务端的网络连接建立后，客户端发送给服务端的第一个报文
     * 固定报头：
     * 				消息类型connect，
     * 				重发标志false,
     * 				qos质量等级AT_LEAST_ONCE(1) , 至少分发一次
     * 				保留标志false，提示服务端不用保存这次发送的消息
     * 				剩余长度字段，等于可变报头的长度加上有效载荷的长度
     * 可变报头：
     * 				协议名:MqttVersion.MQTT_3_1_1.protocolName() = MQTT  ,  UTF-8字符编码
     * 				协议级别：MqttVersion.MQTT_3_1_1.protocolLevel() = 4
     * 				连接标志：
     * 							1.是否有用户名，true或false
     * 							2.是否有密码，true或false  ， 如果用户名为 true，密码一定为 true
     * 							3.遗嘱保留 , 如果遗嘱消息被发布时需要保留，需要指定这一位的值。(遗嘱标志为0，遗嘱保留一定为0)
     * 							4.遗嘱QoS ,遗嘱质量等级(遗嘱标志为0，遗嘱QoS一定为0)
     * 							5.遗嘱标志，0或1表示是否有遗嘱消息，当客户端连接断开之后服务器必须发布遗嘱消息。消息存储在服务端
     * 							6.清理会话，如果设置为0，服务器恢复通信，或者创建新通信。如果设置为1，必须新创建一个通信
     * 				保持连接：可以理解为心跳时间，在规定的时间内没有通信，连接将会断开。
     * 有效载荷：客户端标识符，遗嘱主题，遗嘱消息，用户名，密码（可选，根据报头中的标志确定）
     *
     * MqttMessage connect = MqttMessageFactory.newMessage(固定报头mqttFixedHeader, 可变报头variableHeader, 有效载荷payload)
     * 固定报头，所有控制报文都包含()
     * 可变报头，部分控制报文包含
     * 有效载荷，部分控制报文包含
     *
     */
    public MqttConnectMessage connect() {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.CONNECT, false, MqttQoS.AT_LEAST_ONCE, false, 10);

        //可变报头
        MqttConnectVariableHeader mcvh = new MqttConnectVariableHeader(
                MqttVersion.MQTT_3_1_1.protocolName(), MqttVersion.MQTT_3_1_1.protocolLevel(),
                false, false, false, 0,
                false, false, 30);

        //没有遗嘱消息或者没有账号密码就给空
        byte[] b = "".getBytes();
        //有效载荷
        MqttConnectPayload mcp = new MqttConnectPayload("ClientOne", "",b, "", b);

        //connect报文
        MqttConnectMessage mcm = new MqttConnectMessage(mfh, mcvh, mcp);

        return mcm;
    }

    /**
     * 确认连接请求报文，服务端发送CONNACK报文响应从客户端收到的CONNECT报文。服务端发送给客户端的第一个报文必须是CONNACK
     *
     * 固定报头：
     * 				1.消息类型connack
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 0 最多发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 2 ，  可变报头+有效载荷
     * 可变报头：
     * 			连接状态返回码
     * 				1.CONNECTION_ACCEPTED  0x00 (连接已被服务端接受)
     * 				2.CONNECTION_REFUSED_UNACCEPTABLE_PROTOCOL_VERSION  0x01 (不支持的协议版本)
     * 				3.CONNECTION_REFUSED_IDENTIFIER_REJECTED  0x02 (不合格的客户端标识符)
     * 				4.CONNECTION_REFUSED_SERVER_UNAVAILABLE  0x03 (服务端不可用)
     * 				5.CONNECTION_REFUSED_BAD_USER_NAME_OR_PASSWORD  0x04 (无效的用户名或密码)
     *  			5.CONNECTION_REFUSED_NOT_AUTHORIZED  0x05 (未授权)
     * 			当前会话，搞不太懂这个东西！给false就好了
     * 有效载荷 ： 不需要
     *
     */
    public MqttConnAckMessage connack() {
        //连接状态返回码
        MqttConnectReturnCode mcrc = MqttConnectReturnCode.CONNECTION_ACCEPTED;

        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.CONNACK, false, MqttQoS.AT_MOST_ONCE, false, 0x02);

        //可变报头
        MqttConnAckVariableHeader mcavh = new MqttConnAckVariableHeader(mcrc, false);

        //connack报文
        MqttConnAckMessage mcam = new MqttConnAckMessage(mfh, mcavh);

        return mcam;
    }

    /**
     * 发送消息请求报文，客户端向服务端或者服务端向客户端传输一个应用消息，双向连接
     *
     * 固定报头：
     * 				1.消息类型publish
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 1 最少发送一次
     * 				4.保留标志 true 服务端会保存这次消息,相同订阅主题的消息将会被替换掉
     * 				5.剩余长度 0 ，  用固定报头中的剩余长度字段的值减去可变报头的长度
     * 可变报头：
     * 				1.topicName 主题名称，用于识别有效载荷数据应该被发布到哪一个信息通道
     * 				2.报文标识符，只有当QoS等级是1或2时才有这个。
     *
     * 有效载荷：ByteBuf 对象的应用消息
     */
    public MqttPublishMessage publish(MqttChannel myChannel) {
        //固定报头
        MqttFixedHeader mfh  = new MqttFixedHeader(MqttMessageType.PUBLISH, false, MqttQoS.AT_LEAST_ONCE, true,0);

        //可变报头
        MqttPublishVariableHeader mpvh = new MqttPublishVariableHeader("TopicName", myChannel.messageId());

        //有效载荷， 也就是发送的应用消息
        String msg = "大家好！";
        ByteBuf buf = Unpooled.copiedBuffer(msg.getBytes());

        //publish报文
        MqttPublishMessage mpm = new MqttPublishMessage(mfh, mpvh, buf);
        return mpm;
    }

    /**
     * 确认消息，PUBACK报文是对QoS 1等级的PUBLISH报文的响应。
     *
     * 固定报头：
     * 				1.消息类型puback
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 0 最多发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 0x02 ，  PUBACK报文它的值等于2
     * 可变报头：
     * 				1.报文标识符，只有当QoS等级是1或2时才有这个。
     * 有效载荷：没有
     */
    public MqttPubAckMessage puback(MqttChannel myChannel) {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.PUBACK, false, MqttQoS.AT_MOST_ONCE, false, 0x02);

        //可变报头
        MqttMessageIdVariableHeader mmivh = MqttMessageIdVariableHeader.from(myChannel.messageId());

        //puback报文
        MqttPubAckMessage mpam = new MqttPubAckMessage(mfh, mmivh);
        return mpam;
    }

    /**
     * 确认消息第一步(发布收到)，PUBREC报文是对QoS等级2的PUBLISH报文的响应。它是QoS 2等级协议交换的第二个报文。
     * 固定报头：
     * 				1.消息类型pubrec
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 1 最少发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 2 ，  PUBREC报文它的值等于2
     * 可变报头：
     * 				1.报文标识符，只有当QoS等级是1或2时才有这个。
     * 有效载荷：没有
     */
    public MqttPubAckMessage pubrec(MqttChannel myChannel) {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.PUBREC, false, MqttQoS.AT_LEAST_ONCE, false, 0x02);

        //可变报头
        MqttMessageIdVariableHeader mmivh = MqttMessageIdVariableHeader.from(myChannel.messageId());

        //pubrec报文
        MqttPubAckMessage mpam = new MqttPubAckMessage(mfh, mmivh);
        return mpam;
    }


    /**
     * 确认消息第二步(发布释放)，PUBREL报文是对PUBREC报文的响应。它是QoS 2等级协议交换的第三个报文。
     * 固定报头：
     * 				1.消息类型pubrel
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 1 最少发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 2 ，  PUBREC报文它的值等于2
     * 可变报头：
     * 				1.报文标识符，只有当QoS等级是1或2时才有这个。
     * 有效载荷：没有
     */
    public MqttPubAckMessage pubrel(MqttChannel myChannel) {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.PUBREL, false,MqttQoS.AT_LEAST_ONCE, false, 0x02);

        //可变报头
        MqttMessageIdVariableHeader mmivh = MqttMessageIdVariableHeader.from(myChannel.messageId());

        //pubrel报文
        MqttPubAckMessage mpam = new MqttPubAckMessage(mfh, mmivh);
        return mpam;
    }

    /**
     * 确认消息第三步(发布完成)，PUBCOMP报文是对PUBREL报文的响应。它是QoS 2等级协议交换的第四个也是最后一个报文。
     * 固定报头：
     * 				1.消息类型pubcomp
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 0 最多发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 2 ，  PUBREC报文它的值等于2
     * 可变报头：
     * 				1.报文标识符，只有当QoS等级是1或2时才有这个。
     * 有效载荷：没有
     */
    public MqttPubAckMessage pubcomp(MqttChannel myChannel) {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.PUBCOMP, false, MqttQoS.AT_MOST_ONCE, false, 0x02);

        //可变报头
        MqttMessageIdVariableHeader mmivh = MqttMessageIdVariableHeader.from(myChannel.messageId());

        //pubcomp报文
        MqttPubAckMessage mpam = new MqttPubAckMessage(mfh, mmivh);
        return mpam;
    }

    /**
     * 客户端向服务端发送SUBSCRIBE报文用于创建一个或多个订阅
     * 固定报头：
     * 				1.消息类型subscribe
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 1 最少发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 0x00 ，等于可变报头的长度（2字节）加上有效载荷的长度。
     * 可变报头：
     * 				1.报文标识符，只有当QoS等级是1或2时才有这个。
     * 有效载荷：
     * 				1.订阅主题列表
     */
    public MqttSubscribeMessage subscribe(MqttChannel myChannel) {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.SUBSCRIBE, false, MqttQoS.AT_LEAST_ONCE, false, 0x00);

        //可变报头
        MqttMessageIdVariableHeader mmivh = MqttMessageIdVariableHeader.from(myChannel.messageId());

        //订阅主题列表，参数：主题名称，消息质量等级
        //订阅 “#” 的客户端不会收到任何发布到以 “$” 开头主题的消息。
        //订阅 “+/monitor/Clients” 的客户端不会收到任何发布到 “$SYS/monitor/Clients” 的消息。
        //订阅 “$SYS/#” 的客户端会收到发布到以 “$SYS/” 开头主题的消息。
        //订阅 “$SYS/monitor/+” 的客户端会收到发布到 “$SYS/monitor/Clients” 主题的消息。
        //如果客户端想同时接受以 “$SYS/” 开头主题的消息和不以 $ 开头主题的消息，它需要同时订阅 “#” 和 ““$SYS/#”。
        List<MqttTopicSubscription> mqList = new LinkedList<>();
        MqttTopicSubscription mts = new MqttTopicSubscription("$sys/#", MqttQoS.AT_LEAST_ONCE);
        mqList.add(mts);

        //有效载荷
        MqttSubscribePayload msp = new MqttSubscribePayload(mqList);

        //subscribe报文
        MqttSubscribeMessage msm = new MqttSubscribeMessage(mfh, mmivh, msp);

        return msm;
    }

    /**
     * 订阅确认：服务端发送SUBACK报文给客户端，用于确认它已收到并且正在处理SUBSCRIBE报文。
     * SUBACK报文包含一个返回码清单，它们指定了SUBSCRIBE请求的每个订阅被授予的最大QoS等级。
     *
     * 固定报头：
     * 				1.消息类型suback
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 1 最少发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 0 ，等于可变报头的长度加上有效载荷的长度。
     * 可变报头：
     * 				1.报文标识符，只有当QoS等级是1或2时才有这个。SUBSCRIBE报文发送过来什么，就返回什么标识符
     * 					可变报头包含等待确认的SUBSCRIBE报文的报文标识符。
     * 有效载荷：
     * 				1.有效载荷包含一个返回码清单。每个返回码对应等待确认的SUBSCRIBE报文中的一个主题过滤器。
     * 					返回码的顺序必须和SUBSCRIBE报文中主题过滤器的顺序相同 。
     * 					返回一个或多个数字，对应列表的数量
     */
    public MqttSubAckMessage suback(MqttChannel myChannel) {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.SUBACK, false, MqttQoS.AT_LEAST_ONCE, false, 0x02);

        //可变报头
        MqttMessageIdVariableHeader mmivh = MqttMessageIdVariableHeader.from(myChannel.messageId());

        //QOS等级数字
        int qosZero = 0x00;
        int qosOne = 0x01;
        int qosTwo = 0x02;
        int lose = 0x80; //失败
        //有效载荷
        MqttSubAckPayload msap = new MqttSubAckPayload(qosZero,qosOne,qosTwo,lose);

        //suback报文
        MqttSubAckMessage msam = new MqttSubAckMessage(mfh, mmivh, msap);
        return msam;
    }

    /**
     * 取消订阅：客户端发送UNSUBSCRIBE报文给服务端，用于取消订阅主题。
     *
     * 固定报头：
     * 				1.消息类型unsubscribe
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 1 最少发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 0x02 ，等于可变报头的长度加上有效载荷的长度。
     * 可变报头：
     * 				1.报文标识符，只有当QoS等级是1或2时才有这个。SUBSCRIBE报文发送过来什么，就返回什么标识符
     * 					可变报头包含等待确认的SUBSCRIBE报文的报文标识符。
     * 有效载荷：
     * 				1.有效载荷包含一个返回码清单。每个返回码对应等待确认的SUBSCRIBE报文中的一个主题过滤器。
     * 					返回码的顺序必须和SUBSCRIBE报文中主题过滤器的顺序相同 。
     * 					返回一个或多个数字，对应列表的数量
     */

    public MqttUnsubscribeMessage unsubscribe(MqttChannel myChannel) {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.UNSUBSCRIBE, false, MqttQoS.AT_LEAST_ONCE, false, 0x02);

        //可变报头
        MqttMessageIdVariableHeader mmivh = MqttMessageIdVariableHeader.from(myChannel.messageId());


        //准备取消订阅的主题名称列表
        List<String> topNameList = new LinkedList<>();
        topNameList.add("$sys/#");
        //有效载荷
        MqttUnsubscribePayload mup = new MqttUnsubscribePayload(topNameList);

        //unsubscribe报文
        MqttUnsubscribeMessage mum = new MqttUnsubscribeMessage(mfh, mmivh, mup);

        return mum;
    }

    /**
     * 取消订阅确认：服务端发送UNSUBACK报文给客户端用于确认收到UNSUBSCRIBE报文。
     *
     * 固定报头：
     * 				1.消息类型unsuback
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 0最多少发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 0x02 ，对UNSUBACK报文这个值等于2。
     * 可变报头：
     * 				1.报文标识符，只有当QoS等级是1或2时才有这个。UNSUBSCRIBE报文发送过来什么，就返回什么标识符
     * 					可变报头包含等待确认的UNSUBSCRIBE报文的报文标识符。
     * 有效载荷：没有
     */

    public MqttUnsubAckMessage unsuback(MqttChannel myChannel) {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.UNSUBACK, false, MqttQoS.AT_MOST_ONCE, false, 0x02);

        //可变报头
        MqttMessageIdVariableHeader mmivh = MqttMessageIdVariableHeader.from(myChannel.messageId());

        //unsuback报文
        MqttUnsubAckMessage muam = new MqttUnsubAckMessage(mfh, mmivh);

        return muam;
    }

    /**
     * 心跳请求：保持连接（Keep Alive）处理中用到这个报文，客户端发送PINGREQ报文给服务端
     *
     * 固定报头：
     * 				1.消息类型凭热情pingreq
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 0最多发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 0x00
     * 可变报头：没有
     * 有效载荷：没有
     */

    public MqttMessage pingreq() {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.PINGREQ, false, MqttQoS.AT_MOST_ONCE, false, 0x00);

        //pingreq报文
        MqttMessage mm = new MqttMessage(mfh);

        return mm;
    }

    /**
     * 心跳响应：保持连接（Keep Alive）处理中用到这个报文，服务端发送PINGRESP报文响应客户端的PINGREQ报文。表示服务端还活着。
     *
     * 固定报头：
     * 				1.消息类型凭热情pingresp
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 0最多发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 0x00
     * 可变报头：没有
     * 有效载荷：没有
     */

    public MqttMessage pingresp() {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.PINGRESP, false, MqttQoS.AT_MOST_ONCE, false, 0x00);

        //pingresp报文
        MqttMessage mm = new MqttMessage(mfh);

        return mm;
    }

    /**
     * 断开连接：DISCONNECT报文是客户端发给服务端的最后一个控制报文。表示客户端正常断开连接。
     *
     * 固定报头：
     * 				1.消息类型凭热情pingresp
     * 				2.Dup为false(0)  重复发送标志，表示第一次发送
     * 				3.qos质量等级 ， 0最多发送一次
     * 				4.保留标志 false 服务端不会保存这次消息
     * 				5.剩余长度 0x00
     * 可变报头：没有
     * 有效载荷：没有
     *
     * 客户端发送DISCONNECT报文之后：
     *			必须关闭网络连接
     *			不能通过那个网络连接再发送任何控制报文
     *	服务端在收到DISCONNECT报文时：
     *			必须丢弃任何与当前连接关联的未发布的遗嘱消息
     *			应该关闭网络连接，如果客户端 还没有这么做。
     *
     */

    public MqttMessage disconnect() {
        //固定报头
        MqttFixedHeader mfh = new MqttFixedHeader(MqttMessageType.DISCONNECT, false, MqttQoS.AT_MOST_ONCE, false, 0x00);

        //pingresp报文
        MqttMessage mm = new MqttMessage(mfh);

        return mm;
    }


}
