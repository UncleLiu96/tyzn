package com.tyzn.project.job.core;

import java.util.concurrent.ScheduledFuture;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/9 0009 11:30
 * @desc TODO
 */
public final class ScheduledTask {

    volatile ScheduledFuture<?> future;

    /**
     * 取消定时任务
     */
    public void cancel() {
        ScheduledFuture<?> future = this.future;
        if (future != null) {
            future.cancel(true);
        }
    }
}