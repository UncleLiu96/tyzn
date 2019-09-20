package com.tyzn.project.device.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.tyzn.project.device.domain.RadiotubeDevice;
import com.tyzn.project.device.service.IRadiotubeDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 电磁阀设备Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Controller
@RequestMapping("/system/radiotubeDeviceController")
public class RadiotubeDeviceController extends BaseController
{
    private String prefix = "radiotube/";

    @Autowired
    private IRadiotubeDeviceService radiotubeDeviceService;

    @GetMapping()
    public String device()
    {
        return prefix + "list";
    }


    /**
     * 查询电磁阀设备列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestParam(value = "radiotubeNumber",required = false) String radiotubeNumber,  RadiotubeDevice radiotubeDevice)
    {
        System.out.println(radiotubeDevice.toString());
        System.out.println(radiotubeNumber);
        startPage();
        List<RadiotubeDevice> list = radiotubeDeviceService.selectRadiotubeDeviceList(radiotubeDevice);
        return getDataTable(list);
    }


    /**
     * 新增电磁阀设备
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存电磁阀设备
     */
    @Log(detail = "新增保存电磁阀设备",level = 2,operationType = OperationType.INSERT,operationUnit = OperationUnit.DEVICE)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RadiotubeDevice radiotubeDevice)
    {
        return toAjax(radiotubeDeviceService.insertRadiotubeDevice(radiotubeDevice));
    }

    /**
     * 修改电磁阀设备
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RadiotubeDevice radiotubeDevice = radiotubeDeviceService.selectRadiotubeDeviceById(id);
        mmap.put("radiotubeDevice", radiotubeDevice);
        return prefix + "/edit";
    }

    /**
     * 修改保存电磁阀设备
     */
    @Log(detail = "修改保存电磁阀设备",level = 3,operationType = OperationType.UPDATE,operationUnit = OperationUnit.DEVICE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RadiotubeDevice radiotubeDevice)
    {
        return toAjax(radiotubeDeviceService.updateRadiotubeDevice(radiotubeDevice));
    }

    /**
     * 删除电磁阀设备
     */
    @Log(detail = "删除电磁阀设备",level = 4,operationType = OperationType.DELETE,operationUnit = OperationUnit.DEVICE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(List<Integer> ids)
    {
        return toAjax(radiotubeDeviceService.deleteRadiotubeDeviceByIds(ids));
    }
}
