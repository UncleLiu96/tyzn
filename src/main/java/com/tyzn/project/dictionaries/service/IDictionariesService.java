package com.tyzn.project.dictionaries.service;

import com.tyzn.project.dictionaries.domain.Dictionaries;

import java.util.List;

/**
 * 字典Service接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public interface IDictionariesService 
{
    /**
     * 查询字典
     * 
     * @param id 字典ID
     * @return 字典
     */
    public Dictionaries selectDictionariesById(Long id);

    /**
     * 查询字典列表
     * 
     * @param dictionaries 字典
     * @return 字典集合
     */
    public List<Dictionaries> selectDictionariesList(Dictionaries dictionaries);

    /**
     * 新增字典
     * 
     * @param dictionaries 字典
     * @return 结果
     */
    public int insertDictionaries(Dictionaries dictionaries);

    /**
     * 修改字典
     * 
     * @param dictionaries 字典
     * @return 结果
     */
    public int updateDictionaries(Dictionaries dictionaries);

    /**
     * 批量删除字典
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDictionariesByIds(List<Integer> ids);

    /**
     * 删除字典信息
     * 
     * @param id 字典ID
     * @return 结果
     */
    public int deleteDictionariesById(Long id);
}
