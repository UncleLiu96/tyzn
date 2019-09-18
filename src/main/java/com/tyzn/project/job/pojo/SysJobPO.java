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

    /** 方法参数(设备编号) */
    private String methodParams;

    /** start定时任务启动时间 */
    private String startTime;

    /** 状态:1启动、2关闭 */
    private Integer jobStatus;

    /** 定时任务组 */
    private String jobGroup;

    /** 备注 */
    private String remark;

    /** 创建时间 */
    private String createTime;

    /** 修改时间 */
    private String updateTime;

    public Long getJobid() {
        return jobid;
    }

    public void setJobid(Long jobid) {
        this.jobid = jobid;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getStartMethodName() {
        return startMethodName;
    }

    public void setStartMethodName(String startMethodName) {
        this.startMethodName = startMethodName;
    }

    public String getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(Integer jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
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
            .append("methodParams", getMethodParams())
            .append("startTime", getStartTime())
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
     * Start方法编号
     * @return
     */
    public String jobStartNumber(){
        return getJobid()+getStartMethodName();
    }

}
