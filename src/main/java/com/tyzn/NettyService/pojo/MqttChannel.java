package com.tyzn.NettyService.pojo;


import com.tyzn.NettyService.enums.SessionStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Builder
@Getter
@Setter
public class MqttChannel {
    private String deviceId;//客户端ID

    private boolean isWill;//是否有遗嘱消息

    private Set<String> topic  ;//订阅列表

    private volatile SessionStatus sessionStatus;  // 在线 - 离线    ONLINE , OFFLINE

    //private ConcurrentHashMap<Integer,SendMqttMessage>  message ; // messageId - message(qos1)  // 待确认消息

    private AtomicInteger index ; //原子操作的操作索引

    public int messageId(){
        index = new AtomicInteger();
        for (;;) {
            int current = index.get();
            int next = (current >= Short.MAX_VALUE ? 0: current + 1);
            if (index.compareAndSet(current, next)) {
                return next;
            }
        }
    }

}
