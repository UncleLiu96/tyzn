package com.tyzn.project.log.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 日志对象 system_log
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public class SystemLog
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(type= IdType.AUTO)
    private String id;

    /** 日志等级 */
    private Integer logLevel;

    /** 被操作的对象 */
    private String operationUnit;

    /** 方法名 */
    private String method;

    /** 参数 */
    private String args;

    /** 操作人id */
    private String userId;

    /** 操作人 */
    private String userName;

    /** 日志描述 */
    private String logDescribe;

    /** 操作类型 */
    private String operationType;

    /** 方法运行时间 */
    private Long runTime;

    /** 方法返回值 */
    private String returnValue;

    /** IP地址 */
    private String ipAddress;
    /** 创建时间 */
    private String createTime;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setLogLevel(Integer logLevel)
    {
        this.logLevel = logLevel;
    }

    public Integer getLogLevel()
    {
        return logLevel;
    }
    public void setOperationUnit(String operationUnit) 
    {
        this.operationUnit = operationUnit;
    }

    public String getOperationUnit() 
    {
        return operationUnit;
    }
    public void setMethod(String method) 
    {
        this.method = method;
    }

    public String getMethod() 
    {
        return method;
    }
    public void setArgs(String args) 
    {
        this.args = args;
    }

    public String getArgs() 
    {
        return args;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setLogDescribe(String logDescribe) 
    {
        this.logDescribe = logDescribe;
    }

    public String getLogDescribe() 
    {
        return logDescribe;
    }
    public void setOperationType(String operationType) 
    {
        this.operationType = operationType;
    }

    public String getOperationType() 
    {
        return operationType;
    }
    public void setRunTime(Long runTime) 
    {
        this.runTime = runTime;
    }

    public Long getRunTime() 
    {
        return runTime;
    }
    public void setReturnValue(String returnValue) 
    {
        this.returnValue = returnValue;
    }

    public String getReturnValue() 
    {
        return returnValue;
    }
    public void setIpAddress(String ipAddress) 
    {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() 
    {
        return ipAddress;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("logLevel", getLogLevel())
            .append("operationUnit", getOperationUnit())
            .append("method", getMethod())
            .append("args", getArgs())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("logDescribe", getLogDescribe())
            .append("operationType", getOperationType())
            .append("runTime", getRunTime())
            .append("returnValue", getReturnValue())
            .append("ipAddress", getIpAddress())
            .toString();
    }
}
