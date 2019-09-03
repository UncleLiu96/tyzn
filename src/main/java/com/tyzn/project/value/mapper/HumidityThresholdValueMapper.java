package com.tyzn.project.value.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyzn.project.value.domain.HumidityThresholdValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 湿度阀值Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Mapper
public interface HumidityThresholdValueMapper extends BaseMapper<HumidityThresholdValue>
{
}
