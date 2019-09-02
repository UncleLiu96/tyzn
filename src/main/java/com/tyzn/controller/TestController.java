package com.tyzn.controller;

import com.tyzn.NettyService.InitBean;
import com.tyzn.annotation.Log;
import com.tyzn.enums.OperationType;
import com.tyzn.enums.OperationUnit;
import com.tyzn.service.ISystemUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/2 0002 10:05
 * @desc TODO
 */
@RestController
public class TestController {

    @Resource
    private InitBean initBean;

    @Log(detail = "查询信息",level = 3,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @RequestMapping("test")
    public String test(){
        System.out.println(initBean.getServerName());
        return "测试";
    }

}
