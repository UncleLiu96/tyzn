package com.spray.project.relationship.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableId(type= IdType.AUTO)
    private Long rId;

    /** 定时任务id */
    private Long jobid;

    public void setRId(Long rId) 
    {
        this.rId = rId;
    }

    public Long getRId() 
    {
        return rId;
    }

    public Long getJobid() {
        return jobid;
    }

    public void setJobid(Long jobid) {
        this.jobid = jobid;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rId", getRId())
            .append("jobid", getJobid())
            .toString();
    }
}
