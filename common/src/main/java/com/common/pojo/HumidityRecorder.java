package com.common.pojo;

import java.io.Serializable;

/**
 * @ClassName:humidity_recorder 
 * @Description: TODO(类说明：湿度记录 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class HumidityRecorder implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id; 	//ID
	private String deviceNumber; 	//设备编号
	private double humidity; 	//检查值
	private String createTime; 	//创建时间
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public HumidityRecorder(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param id	ID
	 * @param deviceNumber	设备编号
	 * @param humidity	检查值
	 * @param createTime	创建时间
	 */ 
	public HumidityRecorder(Integer id,String deviceNumber,double humidity,String createTime){
		this.id=id;
		this.deviceNumber=deviceNumber;
		this.humidity=humidity;
		this.createTime=createTime;
	}
	/**
	 * @Title:setId 
	 * @Description: TODO(设置Id	ID)
	 * @param id
	 */ 
	public void setId(Integer id){
		this.id=id;
	}
	/**
	 * @Title:setId 
	 * @Description: TODO(得到Id	ID)
	 * @return Integer
	 */ 
	public Integer getId(){
		return id;
	}
	/**
	 * @Title:setDeviceNumber 
	 * @Description: TODO(设置DeviceNumber	设备编号)
	 * @param deviceNumber
	 */ 
	public void setDeviceNumber(String deviceNumber){
		this.deviceNumber=deviceNumber;
	}
	/**
	 * @Title:setDeviceNumber 
	 * @Description: TODO(得到DeviceNumber	设备编号)
	 * @return String
	 */ 
	public String getDeviceNumber(){
		return deviceNumber;
	}
	/**
	 * @Title:setHumidity 
	 * @Description: TODO(设置Humidity	检查值)
	 * @param humidity
	 */ 
	public void setHumidity(double humidity){
		this.humidity=humidity;
	}
	/**
	 * @Title:setHumidity 
	 * @Description: TODO(得到Humidity	检查值)
	 * @return double
	 */ 
	public double getHumidity(){
		return humidity;
	}
	/**
	 * @Title:setCreateTime 
	 * @Description: TODO(设置CreateTime	创建时间)
	 * @param createTime
	 */ 
	public void setCreateTime(String createTime){
		this.createTime=createTime;
	}
	/**
	 * @Title:setCreateTime 
	 * @Description: TODO(得到CreateTime	创建时间)
	 * @return String
	 */ 
	public String getCreateTime(){
		return createTime;
	}
	/**
	 * @Title:toString 
	 * @Description: TODO(toString)
	 */ 
	public String toString() { 
		return "HumidityRecorder[id=" + id + ",deviceNumber=" + deviceNumber + ",humidity=" + humidity + ","+
		"createTime=" + createTime + "]";
	}
}

