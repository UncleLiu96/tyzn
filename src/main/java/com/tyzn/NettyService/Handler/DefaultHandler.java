package com.tyzn.NettyService.Handler;

import com.tyzn.NettyService.mqtt.MqttChannelMaps;
import com.tyzn.NettyService.mqtt.MqttHandler;
import com.tyzn.NettyService.pojo.MqttChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.mqtt.MqttConnectMessage;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 通信处理类，处理连接，断开，接收消息，心跳，异常等。
 */
@Slf4j
public class DefaultHandler extends SimpleChannelInboundHandler<MqttMessage> {

    @Autowired
    MqttHandler mqttHandler;

    protected AttributeKey<String> _clientId = AttributeKey.valueOf("clientId");

    /**
     *
     * @param ctx
     * @param cause
     * @throws Exception
     * 出现异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //出现异常，断开连接
        log.info(cause.getMessage()+"，关闭连接！");
        ctx.close();
    }

    /**
     *
     * @param ctx
     * @param evt
     * @throws Exception
     * 心跳处理
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case READER_IDLE:   //读

                    break;
                case WRITER_IDLE:   //写

                    break;
                case ALL_IDLE:  //读写都有

                    break;
                default:
                    break;
            }
        }
    }

    /**
     * @param ctx
     * @throws Exception
     * 连接断开处理
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("连接关闭，删除客户端信息");
    }

    /**
     * @param ctx
     * @throws Exception
     * 连接建立处理
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("连接成功，保存客户端信息");
    }

    /**
     * 收到消息处理
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MqttMessage message) throws Exception {
        log.info("收到消息");
        log.info("【" + channelHandlerContext.channel().id() + "】" + " :" + message);
        //channelHandlerContext.writeAndFlush("你好"+channelHandlerContext.channel().id());
        Channel channel = channelHandlerContext.channel();
        MqttFixedHeader fixedHeader = message.fixedHeader();
        //第一步登陆
        if(fixedHeader.messageType().equals(MqttMessageType.CONNECT)){
            if(!mqttHandler.login(channel,(MqttConnectMessage) message)){
                channel.close();
            }
            return;
        }

        MqttChannel mqttChannel = new MqttChannelMaps().getMqttChannel(channel.attr(_clientId).get());

        if(mqttChannel!=null){
            switch (fixedHeader.messageType()){
                case PUBLISH:

                    break;
                case SUBSCRIBE:

                    break;
                case PINGREQ:

                    break;
                case DISCONNECT:

                    break;
                case UNSUBSCRIBE:

                    break;
                case PUBACK:

                    break;
                case PUBREC:

                    break;
                case PUBREL:

                    break;
                case PUBCOMP:

                    break;
                default:
                    break;
            }
        }

    }

}
