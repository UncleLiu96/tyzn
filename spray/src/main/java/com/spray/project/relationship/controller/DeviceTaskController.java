package com.spray.project.relationship.controller;

import java.util.List;

import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.spray.project.relationship.domain.DeviceTask;
import com.spray.project.relationship.service.IDeviceTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 电磁阀设备与定时任务关系Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Controller
@RequestMapping("/system/deviceTaskController")
public class DeviceTaskController extends BaseController
{
    private String prefix = "system/task";

    @Autowired
    private IDeviceTaskService deviceTaskService;

    @GetMapping()
    public String task()
    {
        return prefix + "/task";
    }

    /**
     * 查询电磁阀设备与定时任务关系列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DeviceTask deviceTask)
    {
        startPage();
        List<DeviceTask> list = deviceTaskService.selectDeviceTaskList(deviceTask);
        return getDataTable(list);
    }


    /**
     * 新增电磁阀设备与定时任务关系
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存电磁阀设备与定时任务关系
     */
    @Log(detail = "新增保存电磁阀设备与定时任务关系",level = 2,operationType = OperationType.INSERT,operationUnit = OperationUnit.DEVICE)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DeviceTask deviceTask)
    {
        return toAjax(deviceTaskService.insertDeviceTask(deviceTask));
    }

    /**
     * 修改电磁阀设备与定时任务关系
     */
    @GetMapping("/edit/{rId}")
    public String edit(@PathVariable("rId") Long rId, ModelMap mmap)
    {
        DeviceTask deviceTask = deviceTaskService.selectDeviceTaskById(rId);
        mmap.put("deviceTask", deviceTask);
        return prefix + "/edit";
    }

    /**
     * 修改保存电磁阀设备与定时任务关系
     */
    @Log(detail = "修改保存电磁阀设备与定时任务关系",level = 3,operationType = OperationType.UPDATE,operationUnit = OperationUnit.DEVICE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DeviceTask deviceTask)
    {
        return toAjax(deviceTaskService.updateDeviceTask(deviceTask));
    }

    /**
     * 删除电磁阀设备与定时任务关系
     */
    @Log(detail = "删除电磁阀设备与定时任务关系",level = 4,operationType = OperationType.DELETE,operationUnit = OperationUnit.DEVICE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(List<Integer> ids)
    {
        return toAjax(deviceTaskService.deleteDeviceTaskByIds(ids));
    }
}
