package com.netty.NettyService.service;

/**
 * 登陆处理
 */
public interface ILoginService {
    boolean checkClient(String username, String password);
}
