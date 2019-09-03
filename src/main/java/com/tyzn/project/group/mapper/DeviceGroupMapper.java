package com.tyzn.project.group.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tyzn.project.group.domain.DeviceGroup;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 设备组Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Mapper
public interface DeviceGroupMapper extends BaseMapper<DeviceGroup>
{
}
