package com.tyzn.project.job.pojo;

import com.common.Utils.DateUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 定时任务对象 sys_job_p_o
 * 
 * @author ruoyi
 * @date 2019-09-10
 */
public class SysJobPO
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long jobid;

    /** bean名称 */
    private String beanName;

    /** start方法名称 */
    private String startMethodName;

    /** end方法名称 */
    private String endMethodName;

    /** 方法参数(设备编号) */
    private String methodParams;

    /** start定时任务启动时间 */
    private String startTime;

    /** end定时任务时间 */
    private String endTime;

    /** 状态:1启动、2关闭 */
    private Integer jobStatus;

    /** 备注 */
    private String remark;

    /** 创建时间 */
    private String createTime;

    /** 修改时间 */
    private String updateTime;

    public void setJobid(Long jobid) 
    {
        this.jobid = jobid;
    }

    public Long getJobid() 
    {
        return jobid;
    }
    public void setBeanName(String beanName) 
    {
        this.beanName = beanName;
    }

    public String getBeanName() 
    {
        return beanName;
    }
    public void setStartMethodName(String startMethodName) 
    {
        this.startMethodName = startMethodName;
    }

    public String getStartMethodName() 
    {
        return startMethodName;
    }
    public void setEndMethodName(String endMethodName) 
    {
        this.endMethodName = endMethodName;
    }

    public String getEndMethodName() 
    {
        return endMethodName;
    }
    public void setMethodParams(String methodParams) 
    {
        this.methodParams = methodParams;
    }

    public String getMethodParams() 
    {
        return methodParams;
    }
    public void setStartTime(String startTime) 
    {
        this.startTime = startTime;
    }

    public String getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(String endTime) 
    {
        this.endTime = endTime;
    }

    public String getEndTime() 
    {
        return endTime;
    }
    public void setJobStatus(Integer jobStatus)
    {
        this.jobStatus = jobStatus;
    }

    public Integer getJobStatus()
    {
        return jobStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("jobid", getJobid())
            .append("beanName", getBeanName())
            .append("startMethodName", getStartMethodName())
            .append("endMethodName", getEndMethodName())
            .append("methodParams", getMethodParams())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("jobStatus", getJobStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }

    /**
     * Start表达式
     * @return
     */
    public String getStartCron(){
        return DateUtils.getCron(DateUtils.dateTime("yyyy-MM-dd HH:mm:ss","2000-01-10 "+getStartTime()));
    }

    /**
     * end表达式
     * @return
     */
    public String getEndCron(){
        return DateUtils.getCron(DateUtils.dateTime("yyyy-MM-dd HH:mm:ss","2000-01-10 "+getEndTime()));
    }

    /**
     * Start方法编号
     * @return
     */
    public String jobStartNumber(){
        return getJobid()+getStartMethodName();
    }

    /**
     * end方法编号
     * @return
     */
    public String jobEndNumber(){
        return getJobid()+getEndMethodName();
    }
}
