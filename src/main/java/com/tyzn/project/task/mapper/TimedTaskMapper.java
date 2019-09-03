package com.tyzn.project.task.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyzn.project.task.domain.TimedTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Mapper
public interface TimedTaskMapper extends BaseMapper<TimedTask>
{
}
