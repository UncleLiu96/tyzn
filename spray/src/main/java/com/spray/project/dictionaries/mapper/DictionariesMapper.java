package com.spray.project.dictionaries.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.spray.project.dictionaries.domain.Dictionaries;
import org.apache.ibatis.annotations.Mapper;


/**
 * 字典Mapper接口
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
@Mapper
public interface DictionariesMapper extends BaseMapper<Dictionaries>
{
}
