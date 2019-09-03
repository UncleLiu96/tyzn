package com.tyzn.project.dictionaries.controller;

import java.util.List;

import com.common.annotation.Log;
import com.common.core.controller.BaseController;
import com.common.core.domain.AjaxResult;
import com.common.core.page.TableDataInfo;
import com.common.enums.OperationType;
import com.common.enums.OperationUnit;
import com.tyzn.project.dictionaries.domain.Dictionaries;
import com.tyzn.project.dictionaries.service.IDictionariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 字典Controller
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Controller
@RequestMapping("/system/dictionaries")
public class DictionariesController extends BaseController
{
    private String prefix = "system/dictionaries";

    @Autowired
    private IDictionariesService dictionariesService;

    @GetMapping()
    public String dictionaries()
    {
        return prefix + "/dictionaries";
    }

    /**
     * 查询字典列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Dictionaries dictionaries)
    {
        startPage();
        List<Dictionaries> list = dictionariesService.selectDictionariesList(dictionaries);
        return getDataTable(list);
    }


    /**
     * 新增字典
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存字典
     */
    @Log(detail = "新增保存字典",level = 2,operationType = OperationType.INSERT,operationUnit = OperationUnit.USER)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Dictionaries dictionaries)
    {
        return toAjax(dictionariesService.insertDictionaries(dictionaries));
    }

    /**
     * 修改字典
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Dictionaries dictionaries = dictionariesService.selectDictionariesById(id);
        mmap.put("dictionaries", dictionaries);
        return prefix + "/edit";
    }

    /**
     * 修改保存字典
     */
    @Log(detail = "修改保存字典",level = 3,operationType = OperationType.UPDATE,operationUnit = OperationUnit.USER)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Dictionaries dictionaries)
    {
        return toAjax(dictionariesService.updateDictionaries(dictionaries));
    }

    /**
     * 删除字典
     */
    @Log(detail = "删除字典",level = 4,operationType = OperationType.DELETE,operationUnit = OperationUnit.USER)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(List<Integer> ids)
    {
        return toAjax(dictionariesService.deleteDictionariesByIds(ids));
    }
}
