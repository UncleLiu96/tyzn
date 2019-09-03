package com.tyzn.service;


import com.common.pojo.SystemLog;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author uncle
 * @since 2019-08-30
 */
public interface ISystemLogService {

    int addLog(SystemLog log);

    List<SystemLog> list(SystemLog systemLog);

}
