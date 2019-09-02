package com.tyzn.service.impl;

import com.common.pojo.SystemUser;
import com.tyzn.mapper.SystemUserMapper;
import com.tyzn.service.ISystemUserService;
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
public class SystemUserServiceImpl implements ISystemUserService {

    @Resource
    private SystemUserMapper userMapper;

    @Override
    public SystemUser selectSystemUserByAccount(String account) {
        return userMapper.selectSystemUserByAccount(account);
    }
}
