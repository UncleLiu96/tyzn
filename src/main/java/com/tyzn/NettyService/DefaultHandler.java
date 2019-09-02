package com.tyzn.NettyService;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * 通信处理类，处理连接，断开，接收消息，心跳，异常等。
 */
@Slf4j
public class DefaultHandler extends SimpleChannelInboundHandler<Object> {


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
        log.info("出现异常，关闭连接！");
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
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        log.info("收到消息");
        log.info("【" + channelHandlerContext.channel().id() + "】" + " :" + o);
        channelHandlerContext.writeAndFlush("你好"+channelHandlerContext.channel().id());
    }
}
