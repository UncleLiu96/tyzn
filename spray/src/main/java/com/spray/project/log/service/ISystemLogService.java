package com.spray.project.log.service;

import com.spray.project.log.domain.SystemLog;

import java.util.List;

/**
 * 日志Service接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public interface ISystemLogService 
{
    /**
     * 查询日志
     * 
     * @param id 日志ID
     * @return 日志
     */
    public SystemLog selectSystemLogById(String id);

    /**
     * 查询日志列表
     * 
     * @param systemLog 日志
     * @return 日志集合
     */
    public List<SystemLog> selectSystemLogList(SystemLog systemLog);

    /**
     * 新增日志
     * 
     * @param systemLog 日志
     * @return 结果
     */
    public int insertSystemLog(SystemLog systemLog);


    /**
     * 批量删除日志
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSystemLogByIds(List<Integer> ids);

    /**
     * 删除日志信息
     * 
     * @param id 日志ID
     * @return 结果
     */
    public int deleteSystemLogById(String id);
}
