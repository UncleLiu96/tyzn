package com.tyzn.NettyService.mqtt;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Channel管理类， 存储操作
 */
public class ChannelMap {

    private static Map<String, Channel> map = new ConcurrentHashMap<>();

    //public static ChannelGroup cGroup = new DefaultChannelGroup("TyznGroup", GlobalEventExecutor.INSTANCE);
    public static void addChannel(String id, Channel gateway_channel){
        map.put(id, gateway_channel);
    }

    public static Map<String, Channel> getChannel(){
        return map;
    }

    public static Channel getChannel(String id){
        return map.get(id);
    }

    public static void removeChannel(String id){
        map.remove(id);
    }



//    private static ChannelGroup channelGroup = new DefaultChannelGroup("Tyzn", GlobalEventExecutor.INSTANCE);
//
//    /**
//     * 添加channel
//     * @param channel
//     */
//    public void add(Channel channel){
//        channelGroup.add(channel);
//    }
//
//    /**
//     * 关闭所有channel
//     */
//    public ChannelGroupFuture close(){
//        return channelGroup.close();
//    }
//
//    /**
//     * 关闭指定channel
//     * @param channelMatcher
//     */
//    public ChannelGroupFuture close(ChannelMatcher channelMatcher){
//        return channelGroup.close(channelMatcher);
//    }
//
//    /**
//     * 关闭所有channel的连接
//     */
//    public ChannelGroupFuture disconnect(){
//        return channelGroup.disconnect();
//    }
//
//    /**
//     * 关闭指定channel的连接
//     * @param channelMatcher
//     */
//    public ChannelGroupFuture disconnect(ChannelMatcher channelMatcher){
//        return channelGroup.disconnect(channelMatcher);
//    }
//
//    /**
//     * 发送消息到所有人
//     * @param message
//     * @return
//     */
//    public ChannelGroupFuture writeAndFlush(MqttMessage message){
//        return channelGroup.writeAndFlush(message);
//    }
//
//    /**
//     * 发送消息到指定客户端
//     * @param message
//     * @param channelMatcher
//     * @return
//     */
//    public ChannelGroupFuture writeAndFlush(MqttMessage message,ChannelMatcher channelMatcher){
//        return channelGroup.writeAndFlush(message,channelMatcher);
//    }
//
//    /**
//     * 删除元素
//     * @param channel
//     * @return
//     */
//    public boolean remove(Channel channel){
//        return channelGroup.remove(channel);
//    }
//
//    /**
//     * 获取数量
//     * @return
//     */
//    public int size(){
//        return channelGroup.size();
//    }
}
