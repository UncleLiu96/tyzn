package com.tyzn.project.log.controller;


import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.tyzn.project.log.domain.SystemLog;
import com.tyzn.project.log.service.ISystemLogService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 日志Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Controller
@RequestMapping("/system/log")
public class SystemLogController extends BaseController
{
    private String prefix = "system/log";

    @Autowired
    private ISystemLogService systemLogService;

    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询日志列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SystemLog systemLog)
    {
        startPage();
        List<SystemLog> list = systemLogService.selectSystemLogList(systemLog);
        return getDataTable(list);
    }


    /**
     * 新增日志
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存日志
     */
    @Log(detail = "新增保存日志",level = 2,operationUnit = OperationUnit.DEVICE,operationType = OperationType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SystemLog systemLog)
    {
        return toAjax(systemLogService.insertSystemLog(systemLog));
    }

    /**
     * 修改日志
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        SystemLog systemLog = systemLogService.selectSystemLogById(id);
        mmap.put("systemLog", systemLog);
        return prefix + "/edit";
    }


    /**
     * 删除日志
     */
    @Log(detail = "删除日志",level = 4,operationUnit = OperationUnit.USER,operationType = OperationType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(List<Integer> ids)
    {
        return toAjax(systemLogService.deleteSystemLogByIds(ids));
    }
}
