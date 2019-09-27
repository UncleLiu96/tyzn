package com.spray.project.value.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spray.project.value.mapper.HumidityThresholdValueMapper;
import com.spray.project.value.service.IHumidityThresholdValueService;
import com.spray.project.value.domain.HumidityThresholdValue;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 湿度阀值Service业务层处理
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Service
@Transactional
public class HumidityThresholdValueServiceImpl implements IHumidityThresholdValueService
{
    @Resource
    private HumidityThresholdValueMapper humidityThresholdValueMapper;

    /**
     * 查询湿度阀值
     * 
     * @param hId 湿度阀值ID
     * @return 湿度阀值
     */
    @Override
    public HumidityThresholdValue selectHumidityThresholdValueById(Long hId)
    {
        return humidityThresholdValueMapper.selectById(hId);
    }

    /**
     * 查询湿度阀值列表
     * 
     * @param humidityThresholdValue 湿度阀值
     * @return 湿度阀值
     */
    @Override
    public List<HumidityThresholdValue> selectHumidityThresholdValueList(HumidityThresholdValue humidityThresholdValue)
    {
        QueryWrapper<HumidityThresholdValue> queryWrapper = new QueryWrapper<>(humidityThresholdValue);
        return humidityThresholdValueMapper.selectList(queryWrapper);
    }

    /**
     * 新增湿度阀值
     * 
     * @param humidityThresholdValue 湿度阀值
     * @return 结果
     */
    @Override
    public int insertHumidityThresholdValue(HumidityThresholdValue humidityThresholdValue)
    {
        return humidityThresholdValueMapper.insert(humidityThresholdValue);
    }

    /**
     * 修改湿度阀值
     * 
     * @param humidityThresholdValue 湿度阀值
     * @return 结果
     */
    @Override
    public int updateHumidityThresholdValue(HumidityThresholdValue humidityThresholdValue)
    {
        return humidityThresholdValueMapper.updateById(humidityThresholdValue);
    }

    /**
     * 删除湿度阀值对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHumidityThresholdValueByIds(List<Integer> ids)
    {
        return humidityThresholdValueMapper.deleteBatchIds(ids);
    }

    /**
     * 删除湿度阀值信息
     * 
     * @param hId 湿度阀值ID
     * @return 结果
     */
    public int deleteHumidityThresholdValueById(Long hId)
    {
        return humidityThresholdValueMapper.deleteById(hId);
    }
}
