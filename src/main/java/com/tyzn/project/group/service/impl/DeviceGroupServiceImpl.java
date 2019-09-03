package com.tyzn.project.group.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tyzn.project.group.domain.DeviceGroup;
import com.tyzn.project.group.mapper.DeviceGroupMapper;
import com.tyzn.project.group.service.IDeviceGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 设备组Service业务层处理
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Service
@Transactional
public class DeviceGroupServiceImpl implements IDeviceGroupService
{
    @Resource
    private DeviceGroupMapper deviceGroupMapper;

    /**
     * 查询设备组
     * 
     * @param id 设备组ID
     * @return 设备组
     */
    @Override
    public DeviceGroup selectDeviceGroupById(Long id)
    {
        return deviceGroupMapper.selectById(id);
    }

    /**
     * 查询设备组列表
     * 
     * @param deviceGroup 设备组
     * @return 设备组
     */
    @Override
    public List<DeviceGroup> selectDeviceGroupList(DeviceGroup deviceGroup)
    {
        QueryWrapper<DeviceGroup> queryWrapper = new QueryWrapper<>(deviceGroup);
        return deviceGroupMapper.selectList(queryWrapper);
    }

    /**
     * 新增设备组
     * 
     * @param deviceGroup 设备组
     * @return 结果
     */
    @Override
    public int insertDeviceGroup(DeviceGroup deviceGroup)
    {
        return deviceGroupMapper.insert(deviceGroup);
    }

    /**
     * 修改设备组
     * 
     * @param deviceGroup 设备组
     * @return 结果
     */
    @Override
    public int updateDeviceGroup(DeviceGroup deviceGroup)
    {
        return deviceGroupMapper.updateById(deviceGroup);
    }

    /**
     * 删除设备组对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDeviceGroupByIds(List<Integer> ids)
    {
        return deviceGroupMapper.deleteBatchIds(ids);
    }

    /**
     * 删除设备组信息
     * 
     * @param id 设备组ID
     * @return 结果
     */
    public int deleteDeviceGroupById(Long id)
    {
        return deviceGroupMapper.deleteById(id);
    }
}
