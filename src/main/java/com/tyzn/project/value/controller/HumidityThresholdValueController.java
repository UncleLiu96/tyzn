package com.tyzn.project.value.controller;

import java.util.List;

import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.tyzn.project.value.domain.HumidityThresholdValue;
import com.tyzn.project.value.service.IHumidityThresholdValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 湿度阀值Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Controller
@RequestMapping("/system/value")
public class HumidityThresholdValueController extends BaseController
{
    private String prefix = "system/value";

    @Autowired
    private IHumidityThresholdValueService humidityThresholdValueService;

    @GetMapping()
    public String value()
    {
        return prefix + "/value";
    }

    /**
     * 查询湿度阀值列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HumidityThresholdValue humidityThresholdValue)
    {
        startPage();
        List<HumidityThresholdValue> list = humidityThresholdValueService.selectHumidityThresholdValueList(humidityThresholdValue);
        return getDataTable(list);
    }


    /**
     * 新增湿度阀值
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存湿度阀值
     */
    @Log(detail = "新增保存湿度阀值",level = 2,operationType = OperationType.INSERT,operationUnit = OperationUnit.DEVICE)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HumidityThresholdValue humidityThresholdValue)
    {
        return toAjax(humidityThresholdValueService.insertHumidityThresholdValue(humidityThresholdValue));
    }

    /**
     * 修改湿度阀值
     */
    @GetMapping("/edit/{hId}")
    public String edit(@PathVariable("hId") Long hId, ModelMap mmap)
    {
        HumidityThresholdValue humidityThresholdValue = humidityThresholdValueService.selectHumidityThresholdValueById(hId);
        mmap.put("humidityThresholdValue", humidityThresholdValue);
        return prefix + "/edit";
    }

    /**
     * 修改保存湿度阀值
     */
    @Log(detail = "修改保存湿度阀值",level = 3,operationType = OperationType.UPDATE,operationUnit = OperationUnit.DEVICE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HumidityThresholdValue humidityThresholdValue)
    {
        return toAjax(humidityThresholdValueService.updateHumidityThresholdValue(humidityThresholdValue));
    }

    /**
     * 删除湿度阀值
     */
    @Log(detail = "删除湿度阀值",level = 4,operationType = OperationType.DELETE,operationUnit = OperationUnit.DEVICE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(List<Integer> ids)
    {
        return toAjax(humidityThresholdValueService.deleteHumidityThresholdValueByIds(ids));
    }
}
