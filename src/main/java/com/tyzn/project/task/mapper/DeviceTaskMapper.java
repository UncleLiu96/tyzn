package com.tyzn.project.task.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyzn.project.task.domain.DeviceTask;
import org.apache.ibatis.annotations.Mapper;


/**
 * 电磁阀设备与定时任务关系Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Mapper
public interface DeviceTaskMapper extends BaseMapper<DeviceTask>
{
}
