package com.tyzn.project.test;

import com.common.Utils.Constants;
import com.common.Utils.DateUtils;
import com.tyzn.project.job.core.CronTaskRegistrar;
import com.tyzn.project.job.core.SchedulingRunnable;
import com.tyzn.project.job.pojo.SysJobPO;
import com.tyzn.project.job.service.ISysJobPOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(TestController.class);


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
        sysJob.setMethodParams("23123131,sb123122,asdas1323");
        sysJob.setStartTime("11:21:30");
        sysJob.setJobStatus(1);
        int i = iSysJobPOService.insertSysJobPO(sysJob);
        if (i<=0)
            logger.error("添加失败");
        else {
            if (sysJob.getJobStatus()==1) {
                SchedulingRunnable start = new SchedulingRunnable(sysJob.getBeanName(), sysJob.getStartMethodName(), sysJob.getMethodParams(),sysJob.getJobid());
                cronTaskRegistrar.addCronTask(start,sysJob.getStartCron());
                logger.info("定时任务添加成功");
            }
        }
    }

    @RequestMapping("/close")
    @ResponseBody
    public void close(){
        cronTaskRegistrar.removeCronTask("37deviceStart");
    }
}
