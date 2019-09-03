package com.tyzn.project.device.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.Utils.DateUtils;
import com.tyzn.project.device.domain.RadiotubeDevice;
import com.tyzn.project.device.mapper.RadiotubeDeviceMapper;
import com.tyzn.project.device.service.IRadiotubeDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 电磁阀设备Service业务层处理
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Service
@Transactional
public class RadiotubeDeviceServiceImpl implements IRadiotubeDeviceService
{
    @Autowired
    private RadiotubeDeviceMapper radiotubeDeviceMapper;

    /**
     * 查询电磁阀设备
     * 
     * @param id 电磁阀设备ID
     * @return 电磁阀设备
     */
    @Override
    public RadiotubeDevice selectRadiotubeDeviceById(Long id)
    {
        return radiotubeDeviceMapper.selectById(id);
    }

    /**
     * 查询电磁阀设备列表
     * 
     * @param radiotubeDevice 电磁阀设备
     * @return 电磁阀设备
     */
    @Override
    public List<RadiotubeDevice> selectRadiotubeDeviceList(RadiotubeDevice radiotubeDevice)
    {
        QueryWrapper<RadiotubeDevice> queryWrapper = new QueryWrapper<>(radiotubeDevice);
        return radiotubeDeviceMapper.selectList(queryWrapper);
    }

    /**
     * 新增电磁阀设备
     * 
     * @param radiotubeDevice 电磁阀设备
     * @return 结果
     */
    @Override
    public int insertRadiotubeDevice(RadiotubeDevice radiotubeDevice)
    {
        radiotubeDevice.setCreateTime(DateUtils.getTime());
        return radiotubeDeviceMapper.insert(radiotubeDevice);
    }

    /**
     * 修改电磁阀设备
     * 
     * @param radiotubeDevice 电磁阀设备
     * @return 结果
     */
    @Override
    public int updateRadiotubeDevice(RadiotubeDevice radiotubeDevice)
    {
        radiotubeDevice.setUpdateTime(DateUtils.getTime());
        return radiotubeDeviceMapper.updateById(radiotubeDevice);
    }

    /**
     * 删除电磁阀设备对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRadiotubeDeviceByIds(List<Integer> ids)
    {
        return radiotubeDeviceMapper.deleteBatchIds(ids);
    }

    /**
     * 删除电磁阀设备信息
     * 
     * @param id 电磁阀设备ID
     * @return 结果
     */
    public int deleteRadiotubeDeviceById(Long id)
    {
        return radiotubeDeviceMapper.deleteById(id);
    }
}
