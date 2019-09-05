package com.tyzn;


import com.tyzn.NettyService.pojo.MqttChannel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.concurrent.atomic.AtomicInteger;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TyznApplicationTests {

    public AtomicInteger index ; //原子操作的操作索引


    public int messageId(){
        index = new AtomicInteger();
        for (;;) {
            int current = index.get();
            int next = (current >= Short.MAX_VALUE ? 0: current + 1);
            if (index.compareAndSet(current, next)) {
                return current;
            }
        }
        //System.out.println(index.incrementAndGet());
    }
    @Test
    public void ddd(){
        System.out.println(messageId());
    }

}
