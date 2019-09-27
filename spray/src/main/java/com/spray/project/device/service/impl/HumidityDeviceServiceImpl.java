package com.spray.project.device.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.Utils.DateUtils;
import com.spray.project.device.service.IHumidityDeviceService;
import com.spray.project.device.domain.HumidityDevice;
import com.spray.project.device.mapper.HumidityDeviceMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 湿度检测设备Service业务层处理
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Service
@Transactional
public class HumidityDeviceServiceImpl implements IHumidityDeviceService
{
    @Resource
    private HumidityDeviceMapper humidityDeviceMapper;

    /**
     * 查询湿度检测设备
     * 
     * @param id 湿度检测设备ID
     * @return 湿度检测设备
     */
    @Override
    public HumidityDevice selectHumidityDeviceById(Long id)
    {
        return humidityDeviceMapper.selectById(id);
    }

    /**
     * 查询湿度检测设备列表
     * 
     * @param humidityDevice 湿度检测设备
     * @return 湿度检测设备
     */
    @Override
    public List<HumidityDevice> selectHumidityDeviceList(HumidityDevice humidityDevice)
    {
        QueryWrapper<HumidityDevice> queryWrapper = new QueryWrapper<>(humidityDevice);
        return humidityDeviceMapper.selectList(queryWrapper);
    }

    /**
     * 新增湿度检测设备
     * 
     * @param humidityDevice 湿度检测设备
     * @return 结果
     */
    @Override
    public int insertHumidityDevice(HumidityDevice humidityDevice)
    {
        humidityDevice.setCreateTime(DateUtils.getTime());
        return humidityDeviceMapper.insert(humidityDevice);
    }

    /**
     * 修改湿度检测设备
     * 
     * @param humidityDevice 湿度检测设备
     * @return 结果
     */
    @Override
    public int updateHumidityDevice(HumidityDevice humidityDevice)
    {
        humidityDevice.setUpdateTime(DateUtils.getTime());
        return humidityDeviceMapper.updateById(humidityDevice);
    }

    /**
     * 删除湿度检测设备对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHumidityDeviceByIds(List<Integer> ids)
    {
        return humidityDeviceMapper.deleteBatchIds(ids);
    }

    /**
     * 删除湿度检测设备信息
     * 
     * @param id 湿度检测设备ID
     * @return 结果
     */
    public int deleteHumidityDeviceById(Long id)
    {
        return humidityDeviceMapper.deleteById(id);
    }
}
