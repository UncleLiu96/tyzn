package com.tyzn.service.impl;

import com.common.pojo.SystemLog;
import com.tyzn.mapper.SystemLogMapper;
import com.tyzn.service.ISystemLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author uncle
 * @since 2019-08-30
 */
@Service
@Transactional
public class SystemLogServiceImpl implements ISystemLogService {

    @Resource
    private SystemLogMapper logMapper;

    //    @Override
//    public int addLog(SystemLog log) {
//        return logMapper.addLog(log);
//    }
    @Override
    public int addLog(SystemLog log){
        return logMapper.insert(log);
    }
}

