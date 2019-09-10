package com.tyzn.project.job.core;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.config.CronTask;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/9 0009 11:22
 * @desc TODO 定时任务注册类
 */
@Component
public class CronTaskRegistrar implements DisposableBean {

    private final Map<String, ScheduledTask> scheduledTasks = new ConcurrentHashMap<>();

    @Autowired
    private TaskScheduler taskScheduler;

    public TaskScheduler getScheduler() {
        return this.taskScheduler;
    }

    private SchedulingRunnable schedulingRunnable;

    /**
     * 添加定时任务
     * @param task
     * @param cronExpression
     */
    public void addCronTask(SchedulingRunnable task, String cronExpression) {
        this.schedulingRunnable=task;
        addCronTask(new CronTask(task, cronExpression));
    }

    public void addCronTask(CronTask cronTask) {
        if (cronTask != null) {
            //定时编号
            String jobNumber = this.schedulingRunnable.jobNumber();
            if (this.scheduledTasks.containsKey(jobNumber)) {
                removeCronTask(jobNumber);
            }
            //添加定时
            this.scheduledTasks.put(jobNumber, scheduleCronTask(cronTask));

        }
    }

    /**
     * 移除Cron任务
     * @param jobNumber
     */
    public void removeCronTask(String jobNumber) {
        ScheduledTask scheduledTask = this.scheduledTasks.remove(jobNumber);
        if (scheduledTask != null){
            scheduledTask.cancel();
        }
    }

    /**
     * 安排Cron任务
     * @param cronTask
     * @return
     */
    public ScheduledTask scheduleCronTask(CronTask cronTask) {
        ScheduledTask scheduledTask = new ScheduledTask();
        scheduledTask.future = this.taskScheduler.schedule(cronTask.getRunnable(), cronTask.getTrigger());
        return scheduledTask;
    }


    @Override
    public void destroy() {
        for (ScheduledTask task : this.scheduledTasks.values()) {
            task.cancel();
        }
        this.scheduledTasks.clear();
    }
}