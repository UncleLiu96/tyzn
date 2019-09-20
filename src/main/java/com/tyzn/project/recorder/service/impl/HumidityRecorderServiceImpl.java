package com.tyzn.project.recorder.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.Utils.DateUtils;
import com.tyzn.project.recorder.domain.HumidityRecorder;
import com.tyzn.project.recorder.mapper.HumidityRecorderMapper;
import com.tyzn.project.recorder.service.IHumidityRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 湿度记录Service业务层处理
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Service
@Transactional
public class HumidityRecorderServiceImpl implements IHumidityRecorderService
{
    @Resource
    private HumidityRecorderMapper humidityRecorderMapper;

    /**
     * 查询湿度记录
     * 
     * @param id 湿度记录ID
     * @return 湿度记录
     */
    @Override
    public HumidityRecorder selectHumidityRecorderById(Long id)
    {
        return humidityRecorderMapper.selectById(id);
    }

    /**
     * 查询湿度记录列表
     * 
     * @param humidityRecorder 湿度记录
     * @return 湿度记录
     */
    @Override
    public List<HumidityRecorder> selectHumidityRecorderList(HumidityRecorder humidityRecorder)
    {
        QueryWrapper<HumidityRecorder> queryWrapper = new QueryWrapper<>(humidityRecorder);
        return humidityRecorderMapper.selectList(queryWrapper);
    }

    /**
     * 新增湿度记录
     * 
     * @param humidityRecorder 湿度记录
     * @return 结果
     */
    @Override
    public int insertHumidityRecorder(HumidityRecorder humidityRecorder)
    {
        humidityRecorder.setCreateTime(DateUtils.getTime());
        return humidityRecorderMapper.insertHumidityRecorder(humidityRecorder);
    }


    /**
     * 删除湿度记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHumidityRecorderByIds(List<Integer> ids)
    {
        return humidityRecorderMapper.deleteBatchIds(ids);
    }

    /**
     * 删除湿度记录信息
     * 
     * @param id 湿度记录ID
     * @return 结果
     */
    public int deleteHumidityRecorderById(Long id)
    {
        return humidityRecorderMapper.deleteById(id);
    }
}
