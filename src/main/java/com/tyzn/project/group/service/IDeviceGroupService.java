package com.tyzn.project.group.service;

import com.tyzn.project.group.domain.DeviceGroup;

import java.util.List;

/**
 * 设备组Service接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public interface IDeviceGroupService 
{
    /**
     * 查询设备组
     * 
     * @param id 设备组ID
     * @return 设备组
     */
    public DeviceGroup selectDeviceGroupById(Long id);

    /**
     * 查询设备组列表
     * 
     * @param deviceGroup 设备组
     * @return 设备组集合
     */
    public List<DeviceGroup> selectDeviceGroupList(DeviceGroup deviceGroup);

    /**
     * 新增设备组
     * 
     * @param deviceGroup 设备组
     * @return 结果
     */
    public int insertDeviceGroup(DeviceGroup deviceGroup);

    /**
     * 修改设备组
     * 
     * @param deviceGroup 设备组
     * @return 结果
     */
    public int updateDeviceGroup(DeviceGroup deviceGroup);

    /**
     * 批量删除设备组
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDeviceGroupByIds(List<Integer> ids);

    /**
     * 删除设备组信息
     * 
     * @param id 设备组ID
     * @return 结果
     */
    public int deleteDeviceGroupById(Long id);
}
