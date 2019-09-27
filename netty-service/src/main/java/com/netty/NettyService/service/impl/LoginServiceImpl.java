package com.netty.NettyService.service.impl;

import com.netty.NettyService.service.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {
    @Override
    public boolean checkClient(String username, String password) {
        return true;
    }
}
