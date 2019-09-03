package com.tyzn.controller;

import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.common.pojo.SystemLog;
import com.tyzn.NettyService.InitBean;
import com.tyzn.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author Unclue_liu
 * @organization tyzn
 * @date 2019/9/2 0002 10:05
 * @desc TODO
 */
@RestController
public class TestController extends BaseController {

    @Resource
    private InitBean initBean;
    @Autowired
    private ISystemLogService systemLogService;

    @RequestMapping(value = "list",method = RequestMethod.POST)
    public TableDataInfo page(SystemLog systemLog){
        startPage();
        List<SystemLog> list = systemLogService.list(systemLog);
        return getDataTable(list);
    }

    @Log(detail = "查询信息",level = 3,operationUnit = OperationUnit.USER,operationType = OperationType.SELECT)
    @RequestMapping("test")
    public String test(){
        System.out.println(initBean.getServerName());
        return "测试";
    }

}



