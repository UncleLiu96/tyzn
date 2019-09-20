package com.tyzn.project.dictionaries.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 字典对象 dictionaries
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public class Dictionaries
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(type= IdType.AUTO)
    private Long id;

    /** 标题 */
    private String dictTitle;

    /** 标记 */
    private String dictSign;

    /** 类型 */
    private String dictType;

    /** 编号 */
    private String dictCode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDictTitle(String dictTitle) 
    {
        this.dictTitle = dictTitle;
    }

    public String getDictTitle() 
    {
        return dictTitle;
    }
    public void setDictSign(String dictSign) 
    {
        this.dictSign = dictSign;
    }

    public String getDictSign() 
    {
        return dictSign;
    }
    public void setDictType(String dictType) 
    {
        this.dictType = dictType;
    }

    public String getDictType() 
    {
        return dictType;
    }
    public void setDictCode(String dictCode) 
    {
        this.dictCode = dictCode;
    }

    public String getDictCode() 
    {
        return dictCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dictTitle", getDictTitle())
            .append("dictSign", getDictSign())
            .append("dictType", getDictType())
            .append("dictCode", getDictCode())
            .toString();
    }
}
