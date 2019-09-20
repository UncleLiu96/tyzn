package com.tyzn.project.recorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyzn.project.recorder.domain.HumidityRecorder;
import org.apache.ibatis.annotations.Mapper;


/**
 * 湿度记录Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Mapper
public interface HumidityRecorderMapper extends BaseMapper<HumidityRecorder>
{

}
