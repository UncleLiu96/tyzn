package com.tyzn.project.recorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyzn.project.recorder.domain.HumidityRecorder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 湿度记录Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Mapper
public interface HumidityRecorderMapper extends BaseMapper<HumidityRecorder>
{
    /**
     * 查询湿度记录
     *
     * @param id 湿度记录ID
     * @return 湿度记录
     */
    public HumidityRecorder selectHumidityRecorderById(Long id);

    /**
     * 查询湿度记录列表
     *
     * @param humidityRecorder 湿度记录
     * @return 湿度记录集合
     */
    public List<HumidityRecorder> selectHumidityRecorderList(HumidityRecorder humidityRecorder);

    /**
     * 新增湿度记录
     *
     * @param humidityRecorder 湿度记录
     * @return 结果
     */
    public int insertHumidityRecorder(HumidityRecorder humidityRecorder);


    /**
     * 批量删除湿度记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHumidityRecorderByIds(List<Integer> ids);

    /**
     * 删除湿度记录信息
     *
     * @param id 湿度记录ID
     * @return 结果
     */
    public int deleteHumidityRecorderById(Long id);
}
