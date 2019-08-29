package com.tyzn.pojo;

import java.io.Serializable;

/**
 * @ClassName:humidity_threshold_value 
 * @Description: TODO(类说明：湿度阀值 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class HumidityThresholdValue implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer hId; 	//湿度检测设备id
	private Integer thresholdValue; 	//阀值
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public HumidityThresholdValue(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param hId	湿度检测设备id
	 * @param thresholdValue	阀值
	 */ 
	public HumidityThresholdValue(Integer hId,Integer thresholdValue){
		this.hId=hId;
		this.thresholdValue=thresholdValue;
	}
	/**
	 * @Title:setHId 
	 * @Description: TODO(设置HId	湿度检测设备id)
	 * @param hId
	 */ 
	public void setHId(Integer hId){
		this.hId=hId;
	}
	/**
	 * @Title:setHId 
	 * @Description: TODO(得到HId	湿度检测设备id)
	 * @return Integer
	 */ 
	public Integer getHId(){
		return hId;
	}
	/**
	 * @Title:setThresholdValue 
	 * @Description: TODO(设置ThresholdValue	阀值)
	 * @param thresholdValue
	 */ 
	public void setThresholdValue(Integer thresholdValue){
		this.thresholdValue=thresholdValue;
	}
	/**
	 * @Title:setThresholdValue 
	 * @Description: TODO(得到ThresholdValue	阀值)
	 * @return Integer
	 */ 
	public Integer getThresholdValue(){
		return thresholdValue;
	}
	/**
	 * @Title:toString 
	 * @Description: TODO(toString)
	 */ 
	public String toString() { 
		return "HumidityThresholdValue[hId=" + hId + ",thresholdValue=" + thresholdValue + "]";
	}
}

