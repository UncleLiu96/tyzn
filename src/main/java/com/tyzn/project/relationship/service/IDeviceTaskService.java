package com.tyzn.project.relationship.service;

import com.tyzn.project.relationship.domain.DeviceTask;

import java.util.List;

/**
 * 电磁阀设备与定时任务关系Service接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public interface IDeviceTaskService 
{
    /**
     * 查询电磁阀设备与定时任务关系
     * 
     * @param rId 电磁阀设备与定时任务关系ID
     * @return 电磁阀设备与定时任务关系
     */
    public DeviceTask selectDeviceTaskById(Long rId);

    /**
     * 查询电磁阀设备与定时任务关系列表
     * 
     * @param deviceTask 电磁阀设备与定时任务关系
     * @return 电磁阀设备与定时任务关系集合
     */
    public List<DeviceTask> selectDeviceTaskList(DeviceTask deviceTask);

    /**
     * 新增电磁阀设备与定时任务关系
     * 
     * @param deviceTask 电磁阀设备与定时任务关系
     * @return 结果
     */
    public int insertDeviceTask(DeviceTask deviceTask);

    /**
     * 修改电磁阀设备与定时任务关系
     * 
     * @param deviceTask 电磁阀设备与定时任务关系
     * @return 结果
     */
    public int updateDeviceTask(DeviceTask deviceTask);

    /**
     * 批量删除电磁阀设备与定时任务关系
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDeviceTaskByIds(List<Integer> ids);

    /**
     * 删除电磁阀设备与定时任务关系信息
     * 
     * @param rId 电磁阀设备与定时任务关系ID
     * @return 结果
     */
    public int deleteDeviceTaskById(Long rId);
}
