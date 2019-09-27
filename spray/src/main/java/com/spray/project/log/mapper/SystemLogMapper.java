package com.spray.project.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spray.project.log.domain.SystemLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日志Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Mapper
public interface SystemLogMapper extends BaseMapper<SystemLog>
{
}
