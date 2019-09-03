package com.tyzn.project.task.controller;

import java.util.List;

import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.tyzn.project.task.domain.TimedTask;
import com.tyzn.project.task.service.ITimedTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 定时任务Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Controller
@RequestMapping("/system/timedTaskController")
public class TimedTaskController extends BaseController
{
    private String prefix = "system/task";

    @Autowired
    private ITimedTaskService timedTaskService;

    @GetMapping()
    public String task()
    {
        return prefix + "/task";
    }

    /**
     * 查询定时任务列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TimedTask timedTask)
    {
        startPage();
        List<TimedTask> list = timedTaskService.selectTimedTaskList(timedTask);
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
    public AjaxResult addSave(TimedTask timedTask)
    {
        return toAjax(timedTaskService.insertTimedTask(timedTask));
    }

    /**
     * 修改定时任务
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TimedTask timedTask = timedTaskService.selectTimedTaskById(id);
        mmap.put("timedTask", timedTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存定时任务
     */
    @Log(detail = "修改保存定时任务",level = 3,operationUnit = OperationUnit.UNKNOWN,operationType = OperationType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TimedTask timedTask)
    {
        return toAjax(timedTaskService.updateTimedTask(timedTask));
    }

    /**
     * 删除定时任务
     */
    @Log(detail = "删除定时任务",level = 4,operationUnit = OperationUnit.UNKNOWN,operationType = OperationType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(List<Integer> ids)
    {
        return toAjax(timedTaskService.deleteTimedTaskByIds(ids));
    }
}
