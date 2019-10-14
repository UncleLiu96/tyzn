package com.netty.socket;



import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/23 0023 15:07
 * @desc TODO
 */
@ServerEndpoint("/ws")
@Service
public class WebSocket {

    private static int onlineConunt = 0;
    private  String sid="";
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();
    private static Session session;

    /** 连接建立成功调用的方法 */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid")String sid ){
        this.sid=sid;
        this.session = session;
        //加入 set 中
        webSocketSet.add(this);
        //在线数加1
        addOnlineCount();
    }
    //连接关闭调用的方法
    @OnClose
    public void onClose(){
        //从set中删除
        webSocketSet.remove(this);
        //在线数减1
        subOnlineCount();
    }
    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("来自客户端的消息："+message);
        //群发消息
        for(WebSocket item : webSocketSet){
            //获取当前用户名称
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //发送错误时调用
    @OnError
    public void onError(Session session,Throwable error){
        error.printStackTrace();
    }

    /**
     * 根据编号给指定客户端发送消息
     * @param message 客户端消息
     * @throws IOException
     */
    public static void appointMessage(String message,String sid) throws IOException {
        for(WebSocket item : webSocketSet){
            if(item.getSid().equals(sid)){
                item.sendMessage(message);
            }
        }
    }
    /**
     * 发送消息
     * @param message 客户端消息
     * @throws IOException
     */
    public static void sendMessage(String message) throws IOException {

        session.getBasicRemote().sendText(message);
    }

    /**
     * 发送消息
     * @param strings 在线设备编号集合
     * @throws IOException
     */
    public static void sendMessage(ConcurrentHashMap.KeySetView strings) throws IOException {
        if(strings.size()==0 || getOnlineConunt()==0){//没有客户端连接时不执行
            return;
        }

        session.getBasicRemote().sendText(strings.toString());
    }


    //返回在线数
    private static synchronized int getOnlineConunt() {
        return onlineConunt;
    }
    //当连接人数增加时
    private static synchronized void addOnlineCount() {
        WebSocket.onlineConunt ++;
    }
    //当连接人数减少时
    private static synchronized void subOnlineCount() {
        WebSocket.onlineConunt --;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
