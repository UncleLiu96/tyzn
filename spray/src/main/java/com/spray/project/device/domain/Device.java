package com.spray.project.device.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备组与设备关系对象 device
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public class Device
{
    private static final long serialVersionUID = 1L;

    /** 设备组id */
    @TableId(type= IdType.AUTO)
    private Long gId;

    /** 设备id */
    private Long dId;

    public void setGId(Long gId) 
    {
        this.gId = gId;
    }

    public Long getGId() 
    {
        return gId;
    }
    public void setDId(Long dId) 
    {
        this.dId = dId;
    }

    public Long getDId() 
    {
        return dId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("gId", getGId())
            .append("dId", getDId())
            .toString();
    }
}
