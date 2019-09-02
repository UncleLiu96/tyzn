package com.tyzn.service;


import com.tyzn.pojo.SystemUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author uncle
 * @since 2019-08-30
 */
public interface ISystemUserService {

    SystemUser selectSystemUserByAccount(String account);

}
