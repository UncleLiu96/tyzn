package com.tyzn;


import com.common.Utils.DateUtils;
import com.tyzn.NettyService.pojo.MqttChannel;
import com.tyzn.project.job.core.CronTaskRegistrar;
import com.tyzn.project.job.core.SchedulingRunnable;
import com.tyzn.project.job.pojo.SysJobPO;
import com.tyzn.project.job.service.ISysJobPOService;
import com.tyzn.project.recorder.domain.HumidityRecorder;
import com.tyzn.project.recorder.service.IHumidityRecorderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.concurrent.atomic.AtomicInteger;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TyznApplicationTests {

    public AtomicInteger index ; //原子操作的操作索引

    @Autowired
    private ISysJobPOService iSysJobPOService;
    @Autowired
    private IHumidityRecorderService iHumidityRecorderService;

    @Test
    public void task(){

        HumidityRecorder humidityRecorder = new HumidityRecorder();
        humidityRecorder.setHumidity(1.1);
        humidityRecorder.setDeviceNumber("23");
        iHumidityRecorderService.insertHumidityRecorder(humidityRecorder);
    }


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
