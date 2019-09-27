package com.spray.project.device.service;

import com.spray.project.device.domain.HumidityDevice;

import java.util.List;

/**
 * 湿度检测设备Service接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public interface IHumidityDeviceService 
{
    /**
     * 查询湿度检测设备
     * 
     * @param id 湿度检测设备ID
     * @return 湿度检测设备
     */
    public HumidityDevice selectHumidityDeviceById(Long id);

    /**
     * 查询湿度检测设备列表
     * 
     * @param humidityDevice 湿度检测设备
     * @return 湿度检测设备集合
     */
    public List<HumidityDevice> selectHumidityDeviceList(HumidityDevice humidityDevice);

    /**
     * 新增湿度检测设备
     * 
     * @param humidityDevice 湿度检测设备
     * @return 结果
     */
    public int insertHumidityDevice(HumidityDevice humidityDevice);

    /**
     * 修改湿度检测设备
     * 
     * @param humidityDevice 湿度检测设备
     * @return 结果
     */
    public int updateHumidityDevice(HumidityDevice humidityDevice);

    /**
     * 批量删除湿度检测设备
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHumidityDeviceByIds(List<Integer> ids);

    /**
     * 删除湿度检测设备信息
     * 
     * @param id 湿度检测设备ID
     * @return 结果
     */
    public int deleteHumidityDeviceById(Long id);
}
