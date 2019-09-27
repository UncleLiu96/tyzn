package com.spray.project.group.controller;

import java.util.List;

import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.spray.project.group.service.IDeviceGroupService;
import com.spray.project.group.domain.DeviceGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 设备组Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Controller
@RequestMapping("/system/group")
public class DeviceGroupController extends BaseController
{
    private String prefix = "system/group";

    @Autowired
    private IDeviceGroupService deviceGroupService;

    @GetMapping()
    public String group()
    {
        return prefix + "/group";
    }

    /**
     * 查询设备组列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DeviceGroup deviceGroup)
    {
        startPage();
        List<DeviceGroup> list = deviceGroupService.selectDeviceGroupList(deviceGroup);
        return getDataTable(list);
    }


    /**
     * 新增设备组
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备组
     */
    @Log(detail = "新增保存设备组",level = 2,operationUnit = OperationUnit.DEVICE,operationType = OperationType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DeviceGroup deviceGroup)
    {
        return toAjax(deviceGroupService.insertDeviceGroup(deviceGroup));
    }

    /**
     * 修改设备组
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DeviceGroup deviceGroup = deviceGroupService.selectDeviceGroupById(id);
        mmap.put("deviceGroup", deviceGroup);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备组
     */
    @Log(detail = "修改保存设备组",level = 3,operationUnit = OperationUnit.DEVICE,operationType = OperationType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DeviceGroup deviceGroup)
    {
        return toAjax(deviceGroupService.updateDeviceGroup(deviceGroup));
    }

    /**
     * 删除设备组
     */
    @Log(detail = "删除设备组",level = 4,operationUnit = OperationUnit.DEVICE,operationType = OperationType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(List<Integer> ids)
    {
        return toAjax(deviceGroupService.deleteDeviceGroupByIds(ids));
    }
}
