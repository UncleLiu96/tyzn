package com.tyzn.mapper;

import com.common.pojo.SystemUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author uncle
 * @since 2019-08-30
 */
@Mapper
public interface SystemUserMapper {

    SystemUser selectSystemUserByAccount(String account);

}
