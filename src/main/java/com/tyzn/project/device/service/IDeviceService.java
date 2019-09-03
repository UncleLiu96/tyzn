package com.tyzn.project.device.service;


import com.tyzn.project.device.domain.Device;

import java.util.List;

/**
 * 设备组与设备关系Service接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public interface IDeviceService 
{
    /**
     * 查询设备组与设备关系
     * 
     * @param gId 设备组与设备关系ID
     * @return 设备组与设备关系
     */
    public Device selectDeviceById(Long gId);

    /**
     * 查询设备组与设备关系列表
     * 
     * @param device 设备组与设备关系
     * @return 设备组与设备关系集合
     */
    public List<Device> selectDeviceList(Device device);

    /**
     * 新增设备组与设备关系
     * 
     * @param device 设备组与设备关系
     * @return 结果
     */
    public int insertDevice(Device device);

    /**
     * 修改设备组与设备关系
     * 
     * @param device 设备组与设备关系
     * @return 结果
     */
    public int updateDevice(Device device);

    /**
     * 批量删除设备组与设备关系
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDeviceByIds(List<Integer> ids);

    /**
     * 删除设备组与设备关系信息
     * 
     * @param gId 设备组与设备关系ID
     * @return 结果
     */
    public int deleteDeviceById(Long gId);
}
