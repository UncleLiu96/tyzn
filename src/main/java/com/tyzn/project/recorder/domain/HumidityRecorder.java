package com.tyzn.project.recorder.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 湿度记录对象 humidity_recorder
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public class HumidityRecorder
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @TableId(type= IdType.AUTO)
    private Long id;

    /** 设备编号 */
    private String deviceNumber;

    /** 检查值 */
    private Double humidity;

    /** 创建时间 */
    private String createTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceNumber(String deviceNumber) 
    {
        this.deviceNumber = deviceNumber;
    }

    public String getDeviceNumber() 
    {
        return deviceNumber;
    }
    public void setHumidity(Double humidity) 
    {
        this.humidity = humidity;
    }

    public Double getHumidity() 
    {
        return humidity;
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
            .append("deviceNumber", getDeviceNumber())
            .append("humidity", getHumidity())
            .append("createTime", getCreateTime())
            .toString();
    }
}
