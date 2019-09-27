package com.spray.project.log.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.common.Utils.DateUtils;
import com.spray.project.log.service.ISystemLogService;
import com.spray.project.log.domain.SystemLog;
import com.spray.project.log.mapper.SystemLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 日志Service业务层处理
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Service
@Transactional
public class SystemLogServiceImpl implements ISystemLogService
{
    @Resource
    private SystemLogMapper systemLogMapper;

    /**
     * 查询日志
     * 
     * @param id 日志ID
     * @return 日志
     */
    @Override
    public SystemLog selectSystemLogById(String id)
    {
        return systemLogMapper.selectById(id);
    }

    /**
     * 查询日志列表
     * 
     * @param systemLog 日志
     * @return 日志
     */
    @Override
    public List<SystemLog> selectSystemLogList(SystemLog systemLog)
    {
        QueryWrapper<SystemLog> queryWrapper = new QueryWrapper<>(systemLog);
        return systemLogMapper.selectList(queryWrapper);
    }

    /**
     * 新增日志
     * 
     * @param systemLog 日志
     * @return 结果
     */
    @Override
    public int insertSystemLog(SystemLog systemLog)
    {
        systemLog.setCreateTime(DateUtils.getTime());
        return systemLogMapper.insert(systemLog);
    }


    /**
     * 删除日志对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSystemLogByIds(List<Integer> ids)
    {
        return systemLogMapper.deleteBatchIds(ids);
    }

    /**
     * 删除日志信息
     * 
     * @param id 日志ID
     * @return 结果
     */
    public int deleteSystemLogById(String id)
    {
        return systemLogMapper.deleteById(id);
    }
}
