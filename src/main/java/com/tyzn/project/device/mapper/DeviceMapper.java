package com.tyzn.project.device.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyzn.project.device.domain.Device;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备组与设备关系Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Mapper
public interface DeviceMapper extends BaseMapper<Device> {
}
