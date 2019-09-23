package com.tyzn.project.socket;



import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/23 0023 15:07
 * @desc TODO
 */
@ServerEndpoint("/ws/{sid}")
@Service
public class WebSocket {

/**
 *    这里稍微解释一下这些主要注解的作用 。
 *   • @ServerEndpoint("/ws") ：
 *     表示让 Spring 创建 WebSocket 的服务端点 ，其中请求地址是“／ws”。
 *   • @OnOpen：
 *     标注客户端打开 WebSocket 服务端点调用方法。
 *   • @OnClose ：
 *     标注客户端关 闭 WebSocket 服务端点调用方法。
 *   • @OnMessage ：
 *     标注客户端发送消息， WebSocket 服务端点调用方法。
 *   • @OnError：
 *     标注客户 端请求 WebSocket 服务端点发生异常调用 方法。
 * 因为每一个客户端打开时，都会为其创建一个 WebSocket 对象，所以这里的打开方
 * 法中都会去计数并且将这个对象保存到 CopyOnWriteArraySet 中，这样就可以知道拥有多少连接。对
 * 于关 闭方法则是清除这个对象，并且计数减一。对于消息发送方法 ，则是通过轮询对所有的客户端
 * 连接都给予发送消息，所以所有的连接都可以收到这个消息。但是有时候可能只 是需要发送给特定13.4 WebSocket 应用 309
 * 的用户，则需要得到用户的信息，然后再发送给特定的用户 。
 */

    /**静态变量，用来记录当前在线连接数 。 应该把它设计成线程安全的*/
    private static int onlineConunt = 0;
    /**连接标识编号*/
    private  String sid="";

    /**oncurrent 包的线程安全 Set ，用来存放每个客户端对应的 WebSocketServiceimpl 对象*/
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
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
        System.out.println("有新连接加入！"+sid+"当前在线人数为："+getOnlineConunt());
        try {
            sendMessage("有新的连接加入了！！");
        } catch (IOException e) {
            System.out.println("IO异常");
        }

    }
    //连接关闭调用的方法
    @OnClose
    public void onClose(){
        //从set中删除
        webSocketSet.remove(this);
        //在线数减1
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为："+getOnlineConunt());
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
                System.out.println("发送消息异常");
            }
        }
    }
    //发送错误时调用
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发送错误");
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
        System.out.println(message);
        session.getBasicRemote().sendText(message);
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
