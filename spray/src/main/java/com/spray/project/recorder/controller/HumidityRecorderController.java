package com.spray.project.recorder.controller;

import java.util.List;

import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.spray.project.recorder.domain.HumidityRecorder;
import com.spray.project.recorder.service.IHumidityRecorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 湿度记录Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Controller
@RequestMapping("/system/recorder")
public class HumidityRecorderController extends BaseController
{
    private String prefix = "humidity";

    @Autowired
    private IHumidityRecorderService humidityRecorderService;

    @GetMapping()
    public String recorder()
    {
        return prefix + "/list";
    }

    /**
     * 查询湿度记录列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public TableDataInfo list(HumidityRecorder humidityRecorder)
    {
        startPage();
        List<HumidityRecorder> list = humidityRecorderService.selectHumidityRecorderList(humidityRecorder);
        return getDataTable(list);
    }


    /**
     * 新增湿度记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存湿度记录
     */
    @Log(detail = "新增保存湿度记录",level = 2,operationUnit = OperationUnit.DEVICE,operationType = OperationType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HumidityRecorder humidityRecorder)
    {
        return toAjax(humidityRecorderService.insertHumidityRecorder(humidityRecorder));
    }

    /**
     * 修改湿度记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        HumidityRecorder humidityRecorder = humidityRecorderService.selectHumidityRecorderById(id);
        mmap.put("humidityRecorder", humidityRecorder);
        return prefix + "/edit";
    }



    /**
     * 删除湿度记录
     */
    @Log(detail = "删除湿度记录",level = 4,operationUnit = OperationUnit.DEVICE,operationType = OperationType.UPDATE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(List<Integer> ids)
    {
        return toAjax(humidityRecorderService.deleteHumidityRecorderByIds(ids));
    }
}
