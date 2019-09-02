package com.common.pojo;

import java.io.Serializable;

/**
 * @ClassName:humidity_device 
 * @Description: TODO(类说明：湿度检测设备 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class HumidityDevice implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id; 	//ID
	private String humidityNumber; 	//设备编号
	private String humidityName; 	//设备名称
	private Integer dictId; 	//设备类型
	private String createTime; 	//创建时间
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public HumidityDevice(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param id	ID
	 * @param humidityNumber	设备编号
	 * @param humidityName	设备名称
	 * @param dictId	设备类型
	 * @param createTime	创建时间
	 */ 
	public HumidityDevice(Integer id,String humidityNumber,String humidityName,Integer dictId,String createTime){
		this.id=id;
		this.humidityNumber=humidityNumber;
		this.humidityName=humidityName;
		this.dictId=dictId;
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
	 * @Title:setHumidityNumber 
	 * @Description: TODO(设置HumidityNumber	设备编号)
	 * @param humidityNumber
	 */ 
	public void setHumidityNumber(String humidityNumber){
		this.humidityNumber=humidityNumber;
	}
	/**
	 * @Title:setHumidityNumber 
	 * @Description: TODO(得到HumidityNumber	设备编号)
	 * @return String
	 */ 
	public String getHumidityNumber(){
		return humidityNumber;
	}
	/**
	 * @Title:setHumidityName 
	 * @Description: TODO(设置HumidityName	设备名称)
	 * @param humidityName
	 */ 
	public void setHumidityName(String humidityName){
		this.humidityName=humidityName;
	}
	/**
	 * @Title:setHumidityName 
	 * @Description: TODO(得到HumidityName	设备名称)
	 * @return String
	 */ 
	public String getHumidityName(){
		return humidityName;
	}
	/**
	 * @Title:setDictId 
	 * @Description: TODO(设置DictId	设备类型)
	 * @param dictId
	 */ 
	public void setDictId(Integer dictId){
		this.dictId=dictId;
	}
	/**
	 * @Title:setDictId 
	 * @Description: TODO(得到DictId	设备类型)
	 * @return Integer
	 */ 
	public Integer getDictId(){
		return dictId;
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
		return "HumidityDevice[id=" + id + ",humidityNumber=" + humidityNumber + ",humidityName=" + humidityName + ","+
		"dictId=" + dictId + ",createTime=" + createTime + "]";
	}
}

