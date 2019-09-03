package com.tyzn.project.device.service.impl;

import java.util.List;
import java.util.Queue;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyzn.project.device.domain.Device;
import com.tyzn.project.device.mapper.DeviceMapper;
import com.tyzn.project.device.service.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 设备组与设备关系Service业务层处理
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Service
@Transactional
public class DeviceServiceImpl implements IDeviceService
{
    @Resource
    private DeviceMapper deviceMapper;

    /**
     * 查询设备组与设备关系
     * 
     * @param gId 设备组与设备关系ID
     * @return 设备组与设备关系
     */
    @Override
    public Device selectDeviceById(Long gId)
    {
        return deviceMapper.selectById(gId);
    }

    /**
     * 查询设备组与设备关系列表
     * 
     * @param device 设备组与设备关系
     * @return 设备组与设备关系
     */
    @Override
    public List<Device> selectDeviceList(Device device)
    {
        QueryWrapper<Device> queryWrapper = new QueryWrapper<>(device);
        return deviceMapper.selectList(queryWrapper);
    }

    /**
     * 新增设备组与设备关系
     * 
     * @param device 设备组与设备关系
     * @return 结果
     */
    @Override
    public int insertDevice(Device device)
    {
        return deviceMapper.insert(device);
    }

    /**
     * 修改设备组与设备关系
     * 
     * @param device 设备组与设备关系
     * @return 结果
     */
    @Override
    public int updateDevice(Device device)
    {
        return deviceMapper.updateById(device);
    }

    /**
     * 删除设备组与设备关系对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDeviceByIds(List<Integer> ids)
    {
        return deviceMapper.deleteBatchIds(ids);
    }

    /**
     * 删除设备组与设备关系信息
     * 
     * @param gId 设备组与设备关系ID
     * @return 结果
     */
    public int deleteDeviceById(Long gId)
    {
        return deviceMapper.deleteById(gId);
    }
}
