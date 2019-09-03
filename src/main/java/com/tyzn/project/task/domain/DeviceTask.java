package com.tyzn.project.task.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 电磁阀设备与定时任务关系对象 device_task
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public class DeviceTask
{
    private static final long serialVersionUID = 1L;

    /** 电磁阀id */
    private Long rId;

    /** 定时任务id */
    private Long tId;

    public void setRId(Long rId) 
    {
        this.rId = rId;
    }

    public Long getRId() 
    {
        return rId;
    }
    public void setTId(Long tId) 
    {
        this.tId = tId;
    }

    public Long getTId() 
    {
        return tId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rId", getRId())
            .append("tId", getTId())
            .toString();
    }
}
