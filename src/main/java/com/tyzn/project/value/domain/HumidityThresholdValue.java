package com.tyzn.project.value.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 湿度阀值对象 humidity_threshold_value
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public class HumidityThresholdValue
{
    private static final long serialVersionUID = 1L;

    /** 湿度检测设备id */
    private Long hId;

    /** 阀值 */
    private Long thresholdValue;

    public void setHId(Long hId) 
    {
        this.hId = hId;
    }

    public Long getHId() 
    {
        return hId;
    }
    public void setThresholdValue(Long thresholdValue) 
    {
        this.thresholdValue = thresholdValue;
    }

    public Long getThresholdValue() 
    {
        return thresholdValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hId", getHId())
            .append("thresholdValue", getThresholdValue())
            .toString();
    }
}
