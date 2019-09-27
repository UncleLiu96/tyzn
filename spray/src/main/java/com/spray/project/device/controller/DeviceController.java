package com.spray.project.device.controller;

import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.spray.project.device.domain.Device;
import com.spray.project.device.service.IDeviceService;
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
 * 设备组与设备关系Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Controller
@RequestMapping("/system/device")
public class DeviceController extends BaseController
{

    private String prefix = "system/device";

    @Autowired
    private IDeviceService deviceService;

    @GetMapping()
    public String device()
    {
        return prefix + "/device";
    }

    /**
     * 查询设备组与设备关系列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Device device)
    {
        startPage();
        List<Device> list = deviceService.selectDeviceList(device);
        return getDataTable(list);
    }


    /**
     * 新增设备组与设备关系
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备组与设备关系
     */
    @Log(detail = "设备组与设备关系添加",level = 2,operationUnit = OperationUnit.DEVICE,operationType = OperationType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Device device)
    {
        return toAjax(deviceService.insertDevice(device));
    }

    /**
     * 修改设备组与设备关系
     */
    @GetMapping("/edit/{gId}")
    public String edit(@PathVariable("gId") Long gId, ModelMap mmap)
    {
        Device device = deviceService.selectDeviceById(gId);
        mmap.put("device", device);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备组与设备关系
     */
    @Log(detail = "设备组与设备关系修改",level = 3,operationUnit = OperationUnit.DEVICE,operationType = OperationType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Device device)
    {
        return toAjax(deviceService.updateDevice(device));
    }

    /**
     * 删除设备组与设备关系
     */
    @Log(detail = "设备组与设备关系删除",level = 4,operationUnit = OperationUnit.DEVICE,operationType = OperationType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(List<Integer> ids)
    {
        return toAjax(deviceService.deleteDeviceByIds(ids));
    }
}
