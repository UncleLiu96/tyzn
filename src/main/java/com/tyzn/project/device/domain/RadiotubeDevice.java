package com.tyzn.project.device.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 电磁阀设备对象 radiotube_device
 * 
 * @author Uncle_liu
 * @date 2019-09-03
 */
public class RadiotubeDevice
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 设备编号 */
    private String radiotubeNumber;

    /** 设备名称 */
    private String radiotubeName;

    /** 设备类型 */
    private Long dictId;
    /** 网络状态（开：1  关：0） */
    private Integer networkState;
    /** 是否开关（开：1  关：0） */
    private Integer onOff;

    /** 创建时间 */
    private String createTime;
    /** 修改时间 */
    private String updateTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRadiotubeNumber(String radiotubeNumber) 
    {
        this.radiotubeNumber = radiotubeNumber;
    }

    public String getRadiotubeNumber() 
    {
        return radiotubeNumber;
    }
    public void setRadiotubeName(String radiotubeName) 
    {
        this.radiotubeName = radiotubeName;
    }

    public String getRadiotubeName() 
    {
        return radiotubeName;
    }
    public void setDictId(Long dictId) 
    {
        this.dictId = dictId;
    }

    public Long getDictId() 
    {
        return dictId;
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

    public Integer getNetworkState() {
        return networkState;
    }

    public void setNetworkState(Integer networkState) {
        this.networkState = networkState;
    }

    public Integer getOnOff() {
        return onOff;
    }

    public void setOnOff(Integer onOff) {
        this.onOff = onOff;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("radiotubeNumber", getRadiotubeNumber())
            .append("radiotubeName", getRadiotubeName())
            .append("dictId", getDictId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("networkState", getNetworkState())
            .append("onOff", getOnOff())
            .toString();
    }
}
