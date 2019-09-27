package com.spray.project.device.controller;


import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.spray.project.device.domain.HumidityDevice;
import com.spray.project.device.service.IHumidityDeviceService;
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
 * 湿度检测设备Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Controller
@RequestMapping("/system/humidityDeviceController")
public class HumidityDeviceController extends BaseController
{
    private String prefix = "system/device";

    @Autowired
    private IHumidityDeviceService humidityDeviceService;

    @GetMapping()
    public String device()
    {
        return prefix + "/device";
    }

    /**
     * 查询湿度检测设备列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HumidityDevice humidityDevice)
    {
        startPage();
        List<HumidityDevice> list = humidityDeviceService.selectHumidityDeviceList(humidityDevice);
        return getDataTable(list);
    }


    /**
     * 新增湿度检测设备
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存湿度检测设备
     */
    @Log(detail = "新增保存湿度检测设备",level = 2,operationUnit = OperationUnit.DEVICE,operationType = OperationType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HumidityDevice humidityDevice)
    {
        return toAjax(humidityDeviceService.insertHumidityDevice(humidityDevice));
    }

    /**
     * 修改湿度检测设备
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HumidityDevice humidityDevice = humidityDeviceService.selectHumidityDeviceById(id);
        mmap.put("humidityDevice", humidityDevice);
        return prefix + "/edit";
    }

    /**
     * 修改保存湿度检测设备
     */
    @Log(detail = "修改保存湿度检测设备",level = 3,operationUnit = OperationUnit.DEVICE,operationType = OperationType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HumidityDevice humidityDevice)
    {
        return toAjax(humidityDeviceService.updateHumidityDevice(humidityDevice));
    }

    /**
     * 删除湿度检测设备
     */
    @Log(detail = "删除湿度检测设备",level = 4,operationUnit = OperationUnit.DEVICE,operationType = OperationType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(List<Integer> ids)
    {
        return toAjax(humidityDeviceService.deleteHumidityDeviceByIds(ids));
    }
}
