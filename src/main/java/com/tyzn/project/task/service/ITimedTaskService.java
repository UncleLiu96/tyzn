package com.tyzn.project.task.service;

import com.tyzn.project.task.domain.TimedTask;

import java.util.List;

/**
 * 定时任务Service接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public interface ITimedTaskService 
{
    /**
     * 查询定时任务
     * 
     * @param id 定时任务ID
     * @return 定时任务
     */
    public TimedTask selectTimedTaskById(Long id);

    /**
     * 查询定时任务列表
     * 
     * @param timedTask 定时任务
     * @return 定时任务集合
     */
    public List<TimedTask> selectTimedTaskList(TimedTask timedTask);

    /**
     * 新增定时任务
     * 
     * @param timedTask 定时任务
     * @return 结果
     */
    public int insertTimedTask(TimedTask timedTask);

    /**
     * 修改定时任务
     * 
     * @param timedTask 定时任务
     * @return 结果
     */
    public int updateTimedTask(TimedTask timedTask);

    /**
     * 批量删除定时任务
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTimedTaskByIds(List<Integer> ids);

    /**
     * 删除定时任务信息
     * 
     * @param id 定时任务ID
     * @return 结果
     */
    public int deleteTimedTaskById(Long id);
}
