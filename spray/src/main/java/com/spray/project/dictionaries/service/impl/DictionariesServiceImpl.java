package com.spray.project.dictionaries.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spray.project.dictionaries.service.IDictionariesService;
import com.spray.project.dictionaries.domain.Dictionaries;
import com.spray.project.dictionaries.mapper.DictionariesMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 字典Service业务层处理
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Service
@Transactional
public class DictionariesServiceImpl implements IDictionariesService
{
    @Resource
    private DictionariesMapper dictionariesMapper;

    /**
     * 查询字典
     * 
     * @param id 字典ID
     * @return 字典
     */
    @Override
    public Dictionaries selectDictionariesById(Long id)
    {
        return dictionariesMapper.selectById(id);
    }

    /**
     * 查询字典列表
     * 
     * @param dictionaries 字典
     * @return 字典
     */
    @Override
    public List<Dictionaries> selectDictionariesList(Dictionaries dictionaries)
    {
        QueryWrapper<Dictionaries> queryWrapper = new QueryWrapper<>(dictionaries);
        return dictionariesMapper.selectList(queryWrapper);
    }

    /**
     * 新增字典
     * 
     * @param dictionaries 字典
     * @return 结果
     */
    @Override
    public int insertDictionaries(Dictionaries dictionaries)
    {
        return dictionariesMapper.insert(dictionaries);
    }

    /**
     * 修改字典
     * 
     * @param dictionaries 字典
     * @return 结果
     */
    @Override
    public int updateDictionaries(Dictionaries dictionaries)
    {
        return dictionariesMapper.updateById(dictionaries);
    }

    /**
     * 删除字典对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDictionariesByIds(List<Integer> ids)
    {
        return dictionariesMapper.deleteBatchIds(ids);
    }

    /**
     * 删除字典信息
     * 
     * @param id 字典ID
     * @return 结果
     */
    public int deleteDictionariesById(Long id)
    {
        return dictionariesMapper.deleteById(id);
    }
}
