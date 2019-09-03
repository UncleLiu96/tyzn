package com.tyzn.controller;

import com.common.annotation.Log;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.tyzn.NettyService.pojo.InitBean;
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
