package com.tyzn;


import com.common.Utils.DateUtils;
import com.tyzn.NettyService.pojo.MqttChannel;
import com.tyzn.project.job.core.CronTaskRegistrar;
import com.tyzn.project.job.core.SchedulingRunnable;
import com.tyzn.project.job.pojo.SysJobPO;
import com.tyzn.project.job.service.ISysJobPOService;
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

    @Test
    public void task(){

        SysJobPO sysJob = new SysJobPO();
        sysJob.setBeanName("demoTask");
//        sysJob.setMethodName("taskWithParams");
        sysJob.setMethodParams("23123131,sb123122,asdas1323");
        sysJob.setStartTime("14:54:30");
        sysJob.setJobStatus(1);
        sysJob.setEndTime("16:54:30");
        iSysJobPOService.deleteSysJobPOByIds("4");
//        int i = iSysJobPOService.insertSysJobPO(sysJob);
        System.out.println("----"+sysJob.getJobid());
//        System.out.println(i);
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
