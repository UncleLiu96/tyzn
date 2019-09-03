package com.tyzn.project.device.service;

import com.tyzn.project.device.domain.RadiotubeDevice;

import java.util.List;

/**
 * 电磁阀设备Service接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public interface IRadiotubeDeviceService 
{
    /**
     * 查询电磁阀设备
     * 
     * @param id 电磁阀设备ID
     * @return 电磁阀设备
     */
    public RadiotubeDevice selectRadiotubeDeviceById(Long id);

    /**
     * 查询电磁阀设备列表
     * 
     * @param radiotubeDevice 电磁阀设备
     * @return 电磁阀设备集合
     */
    public List<RadiotubeDevice> selectRadiotubeDeviceList(RadiotubeDevice radiotubeDevice);

    /**
     * 新增电磁阀设备
     * 
     * @param radiotubeDevice 电磁阀设备
     * @return 结果
     */
    public int insertRadiotubeDevice(RadiotubeDevice radiotubeDevice);

    /**
     * 修改电磁阀设备
     * 
     * @param radiotubeDevice 电磁阀设备
     * @return 结果
     */
    public int updateRadiotubeDevice(RadiotubeDevice radiotubeDevice);

    /**
     * 批量删除电磁阀设备
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRadiotubeDeviceByIds(List<Integer> ids);

    /**
     * 删除电磁阀设备信息
     * 
     * @param id 电磁阀设备ID
     * @return 结果
     */
    public int deleteRadiotubeDeviceById(Long id);
}
