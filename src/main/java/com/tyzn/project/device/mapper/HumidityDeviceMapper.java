package com.tyzn.project.device.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyzn.project.device.domain.HumidityDevice;
import org.apache.ibatis.annotations.Mapper;


/**
 * 湿度检测设备Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Mapper
public interface HumidityDeviceMapper extends BaseMapper<HumidityDevice> {
}
