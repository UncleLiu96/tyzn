package com.tyzn.project.value.service;

import com.tyzn.project.value.domain.HumidityThresholdValue;

import java.util.List;

/**
 * 湿度阀值Service接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public interface IHumidityThresholdValueService 
{
    /**
     * 查询湿度阀值
     * 
     * @param hId 湿度阀值ID
     * @return 湿度阀值
     */
    public HumidityThresholdValue selectHumidityThresholdValueById(Long hId);

    /**
     * 查询湿度阀值列表
     * 
     * @param humidityThresholdValue 湿度阀值
     * @return 湿度阀值集合
     */
    public List<HumidityThresholdValue> selectHumidityThresholdValueList(HumidityThresholdValue humidityThresholdValue);

    /**
     * 新增湿度阀值
     * 
     * @param humidityThresholdValue 湿度阀值
     * @return 结果
     */
    public int insertHumidityThresholdValue(HumidityThresholdValue humidityThresholdValue);

    /**
     * 修改湿度阀值
     * 
     * @param humidityThresholdValue 湿度阀值
     * @return 结果
     */
    public int updateHumidityThresholdValue(HumidityThresholdValue humidityThresholdValue);

    /**
     * 批量删除湿度阀值
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHumidityThresholdValueByIds(List<Integer> ids);

    /**
     * 删除湿度阀值信息
     * 
     * @param hId 湿度阀值ID
     * @return 结果
     */
    public int deleteHumidityThresholdValueById(Long hId);
}
