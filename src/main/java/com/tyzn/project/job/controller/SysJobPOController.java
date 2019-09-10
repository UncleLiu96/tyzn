package com.tyzn.project.job.controller;

import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.tyzn.project.job.pojo.SysJobPO;
import com.tyzn.project.job.service.ISysJobPOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 定时任务Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-09
 */
@Controller
@RequestMapping("/system/o")
public class SysJobPOController extends BaseController
{
    private String prefix = "system/o";

    @Autowired
    private ISysJobPOService sysJobPOService;

    @GetMapping()
    public String o()
    {
        return prefix + "/o";
    }

    /**
     * 查询定时任务列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysJobPO sysJobPO)
    {
        startPage();
        List<SysJobPO> list = sysJobPOService.selectSysJobPOList(sysJobPO);
        return getDataTable(list);
    }

    /**
     * 新增定时任务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存定时任务
     */
    @Log(detail = "新增保存定时任务",level = 2,operationUnit = OperationUnit.UNKNOWN,operationType = OperationType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysJobPO sysJobPO)
    {
        return toAjax(sysJobPOService.insertSysJobPO(sysJobPO));
    }

    /**
     * 修改定时任务
     */
    @GetMapping("/edit/{jobid}")
    public String edit(@PathVariable("jobid") Long jobid, ModelMap mmap)
    {
        SysJobPO sysJobPO = sysJobPOService.selectSysJobPOById(jobid);
        mmap.put("sysJobPO", sysJobPO);
        return prefix + "/edit";
    }

    /**
     * 修改保存定时任务
     */
    @Log(detail = "修改保存定时任务",level = 3,operationUnit = OperationUnit.UNKNOWN,operationType = OperationType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysJobPO sysJobPO)
    {
        return toAjax(sysJobPOService.updateSysJobPO(sysJobPO));
    }

    /**
     * 删除定时任务
     */
    @Log(detail = "删除定时任务",level = 4,operationUnit = OperationUnit.UNKNOWN,operationType = OperationType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysJobPOService.deleteSysJobPOByIds(ids));
    }
}
