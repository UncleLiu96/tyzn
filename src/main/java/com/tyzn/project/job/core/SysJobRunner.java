package com.tyzn.project.job.core;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.tyzn.project.job.pojo.SysJobPO;
import com.tyzn.project.job.service.ISysJobPOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/9 0009 13:58
 * @desc TODO 启动加载数据库正常状态的定时任务
 */
@Service
public class SysJobRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SysJobRunner.class);

    @Autowired
    private ISysJobPOService iSysJobPOService;

    @Autowired
    private CronTaskRegistrar cronTaskRegistrar;

    @Override
    public void run(String... args) {
        // 初始加载数据库里状态为正常的定时任务
        SysJobPO jobPO = new SysJobPO();
        jobPO.setJobStatus(1);
        List<SysJobPO> jobList = iSysJobPOService.selectSysJobPOList(jobPO);
        if (CollectionUtils.isNotEmpty(jobList)) {
            for (SysJobPO job : jobList) {
                //起始
                SchedulingRunnable start = new SchedulingRunnable(job.getBeanName(), job.getStartMethodName(), job.getMethodParams(),job.getJobid());
                cronTaskRegistrar.addCronTask(start, job.getStartCron());
                //结束
                SchedulingRunnable end = new SchedulingRunnable(job.getBeanName(), job.getEndMethodName(), job.getMethodParams(),job.getJobid());
                cronTaskRegistrar.addCronTask(end, job.getEndCron());
            }

            logger.info("定时任务已加载完毕...");
        }
    }
}
