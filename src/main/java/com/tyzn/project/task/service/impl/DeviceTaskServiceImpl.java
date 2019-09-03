package com.tyzn.project.task.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyzn.project.task.domain.DeviceTask;
import com.tyzn.project.task.mapper.DeviceTaskMapper;
import com.tyzn.project.task.service.IDeviceTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 电磁阀设备与定时任务关系Service业务层处理
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Service
@Transactional
public class DeviceTaskServiceImpl implements IDeviceTaskService
{
    @Resource
    private DeviceTaskMapper deviceTaskMapper;

    /**
     * 查询电磁阀设备与定时任务关系
     * 
     * @param rId 电磁阀设备与定时任务关系ID
     * @return 电磁阀设备与定时任务关系
     */
    @Override
    public DeviceTask selectDeviceTaskById(Long rId)
    {
        return deviceTaskMapper.selectById(rId);
    }

    /**
     * 查询电磁阀设备与定时任务关系列表
     * 
     * @param deviceTask 电磁阀设备与定时任务关系
     * @return 电磁阀设备与定时任务关系
     */
    @Override
    public List<DeviceTask> selectDeviceTaskList(DeviceTask deviceTask)
    {
        QueryWrapper<DeviceTask> queryWrapper = new QueryWrapper<>(deviceTask);
        return deviceTaskMapper.selectList(queryWrapper);
    }

    /**
     * 新增电磁阀设备与定时任务关系
     * 
     * @param deviceTask 电磁阀设备与定时任务关系
     * @return 结果
     */
    @Override
    public int insertDeviceTask(DeviceTask deviceTask)
    {
        return deviceTaskMapper.insert(deviceTask);
    }

    /**
     * 修改电磁阀设备与定时任务关系
     * 
     * @param deviceTask 电磁阀设备与定时任务关系
     * @return 结果
     */
    @Override
    public int updateDeviceTask(DeviceTask deviceTask)
    {
        return deviceTaskMapper.updateById(deviceTask);
    }

    /**
     * 删除电磁阀设备与定时任务关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDeviceTaskByIds(List<Integer> ids )
    {
        return deviceTaskMapper.deleteBatchIds(ids);
    }

    /**
     * 删除电磁阀设备与定时任务关系信息
     * 
     * @param rId 电磁阀设备与定时任务关系ID
     * @return 结果
     */
    public int deleteDeviceTaskById(Long rId)
    {
        return deviceTaskMapper.deleteById(rId);
    }
}
