package com.tyzn.project.test;

import com.common.Utils.Constants;
import com.common.Utils.DateUtils;
import com.tyzn.project.job.core.CronTaskRegistrar;
import com.tyzn.project.job.core.SchedulingRunnable;
import com.tyzn.project.job.pojo.SysJobPO;
import com.tyzn.project.job.service.ISysJobPOService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/9 0009 11:45
 * @desc TODO
 */
@Controller
@Transactional
public class TestController {


    @Resource
    private ISysJobPOService iSysJobPOService;
    @Resource
    private CronTaskRegistrar cronTaskRegistrar;

    @RequestMapping("/")
    @ResponseBody
    public void test(){
        SysJobPO sysJob = new SysJobPO();
        sysJob.setBeanName("equipmentTask");
        sysJob.setStartMethodName("deviceStart");
        sysJob.setEndMethodName("deviceClose");
        sysJob.setMethodParams("23123131,sb123122,asdas1323");
        sysJob.setStartTime("11:25:00");
        sysJob.setEndTime("11:25:50");
        sysJob.setJobStatus(1);
        int i = iSysJobPOService.insertSysJobPO(sysJob);
        if (i<=0)
            System.out.println("添加失败");
        else {
            if (sysJob.getJobStatus()==1) {
                SchedulingRunnable start = new SchedulingRunnable(sysJob.getBeanName(), sysJob.getStartMethodName(), sysJob.getMethodParams(),sysJob.getJobid());
                cronTaskRegistrar.addCronTask(start,sysJob.getStartCron());

                SchedulingRunnable end = new SchedulingRunnable(sysJob.getBeanName(), sysJob.getEndMethodName(), sysJob.getMethodParams(),sysJob.getJobid());
                cronTaskRegistrar.addCronTask(end,sysJob.getEndCron());
                System.out.println("**");
            }
        }
    }

    @RequestMapping("/close")
    @ResponseBody
    public void close(){
        cronTaskRegistrar.removeCronTask("37deviceStart");
    }
}
