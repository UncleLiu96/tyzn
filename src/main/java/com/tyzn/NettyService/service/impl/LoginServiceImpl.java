package com.tyzn.NettyService.service.impl;

import com.tyzn.NettyService.service.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {
    @Override
    public boolean checkClient(String username, String password) {
        return true;
    }
}
