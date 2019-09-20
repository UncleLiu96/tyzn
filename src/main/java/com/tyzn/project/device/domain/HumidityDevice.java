package com.tyzn.project.device.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 湿度检测设备对象 humidity_device
 *
 * @author Uncle_liu
 * @date 2019-09-03
 */
public class HumidityDevice {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(type= IdType.AUTO)
    private Long id;

    /**
     * 设备编号
     */
    private String humidityNumber;

    /**
     * 设备名称
     */
    private String humidityName;

    /**
     * 设备类型
     */
    private Long dictId;
    /**
     * 网络状态（开：1  关：0）
     */
    private Integer networkState;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 修改时间
     */
    private String updateTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setHumidityNumber(String humidityNumber) {
        this.humidityNumber = humidityNumber;
    }

    public String getHumidityNumber() {
        return humidityNumber;
    }

    public void setHumidityName(String humidityName) {
        this.humidityName = humidityName;
    }

    public String getHumidityName() {
        return humidityName;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public Long getDictId() {
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


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("humidityNumber", getHumidityNumber())
                .append("humidityName", getHumidityName())
                .append("dictId", getDictId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("networkState", getNetworkState())
                .toString();
    }
}
