package com.tyzn.mapper;

import com.tyzn.pojo.SystemLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/8/31 0031 10:09
 * @desc TODO
 */
@Mapper
public interface SystemLogMapper {
    int addLog(SystemLog log);
}
