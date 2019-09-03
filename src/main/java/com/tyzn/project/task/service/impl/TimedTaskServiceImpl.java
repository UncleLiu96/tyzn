package com.tyzn.project.task.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.Utils.DateUtils;
import com.tyzn.project.task.domain.TimedTask;
import com.tyzn.project.task.mapper.TimedTaskMapper;
import com.tyzn.project.task.service.ITimedTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 定时任务Service业务层处理
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Service
@Transactional
public class TimedTaskServiceImpl implements ITimedTaskService
{
    @Resource
    private TimedTaskMapper timedTaskMapper;

    /**
     * 查询定时任务
     * 
     * @param id 定时任务ID
     * @return 定时任务
     */
    @Override
    public TimedTask selectTimedTaskById(Long id)
    {
        return timedTaskMapper.selectById(id);
    }

    /**
     * 查询定时任务列表
     * 
     * @param timedTask 定时任务
     * @return 定时任务
     */
    @Override
    public List<TimedTask> selectTimedTaskList(TimedTask timedTask)
    {
        QueryWrapper<TimedTask> queryWrapper = new QueryWrapper<>(timedTask);
        return timedTaskMapper.selectList(queryWrapper);
    }

    /**
     * 新增定时任务
     * 
     * @param timedTask 定时任务
     * @return 结果
     */
    @Override
    public int insertTimedTask(TimedTask timedTask)
    {
        timedTask.setCreateTime(DateUtils.getTime());
        return timedTaskMapper.insert(timedTask);
    }

    /**
     * 修改定时任务
     * 
     * @param timedTask 定时任务
     * @return 结果
     */
    @Override
    public int updateTimedTask(TimedTask timedTask)
    {
        timedTask.setUpdateTime(DateUtils.getTime());
        return timedTaskMapper.updateById(timedTask);
    }

    /**
     * 删除定时任务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTimedTaskByIds(List<Integer> ids)
    {
        return timedTaskMapper.deleteBatchIds(ids);
    }

    /**
     * 删除定时任务信息
     * 
     * @param id 定时任务ID
     * @return 结果
     */
    public int deleteTimedTaskById(Long id)
    {
        return timedTaskMapper.deleteById(id);
    }
}
