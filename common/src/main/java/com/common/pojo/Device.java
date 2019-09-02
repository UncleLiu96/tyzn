package com.common.pojo;

import java.io.Serializable;

/**
 * @ClassName:device 
 * @Description: TODO(类说明：设备组与设备关系表 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class Device implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer gId; 	//设备组id
	private Integer dId; 	//设备id
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public Device(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param gId	设备组id
	 * @param dId	设备id
	 */ 
	public Device(Integer gId,Integer dId){
		this.gId=gId;
		this.dId=dId;
	}
	/**
	 * @Title:setGId 
	 * @Description: TODO(设置GId	设备组id)
	 * @param gId
	 */ 
	public void setGId(Integer gId){
		this.gId=gId;
	}
	/**
	 * @Title:setGId 
	 * @Description: TODO(得到GId	设备组id)
	 * @return Integer
	 */ 
	public Integer getGId(){
		return gId;
	}
	/**
	 * @Title:setDId 
	 * @Description: TODO(设置DId	设备id)
	 * @param dId
	 */ 
	public void setDId(Integer dId){
		this.dId=dId;
	}
	/**
	 * @Title:setDId 
	 * @Description: TODO(得到DId	设备id)
	 * @return Integer
	 */ 
	public Integer getDId(){
		return dId;
	}
	/**
	 * @Title:toString 
	 * @Description: TODO(toString)
	 */ 
	public String toString() { 
		return "Device[gId=" + gId + ",dId=" + dId + "]";
	}
}

