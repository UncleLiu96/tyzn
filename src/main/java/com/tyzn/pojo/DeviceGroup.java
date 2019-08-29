package com.tyzn.pojo;

import java.io.Serializable;

/**
 * @ClassName:device_group 
 * @Description: TODO(类说明：设备组 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class DeviceGroup implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id; 	//ID
	private String groupName; 	//名称
	private String address; 	//安装位置
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public DeviceGroup(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param id	ID
	 * @param groupName	名称
	 * @param address	安装位置
	 */ 
	public DeviceGroup(Integer id,String groupName,String address){
		this.id=id;
		this.groupName=groupName;
		this.address=address;
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
	 * @Title:setGroupName 
	 * @Description: TODO(设置GroupName	名称)
	 * @param groupName
	 */ 
	public void setGroupName(String groupName){
		this.groupName=groupName;
	}
	/**
	 * @Title:setGroupName 
	 * @Description: TODO(得到GroupName	名称)
	 * @return String
	 */ 
	public String getGroupName(){
		return groupName;
	}
	/**
	 * @Title:setAddress 
	 * @Description: TODO(设置Address	安装位置)
	 * @param address
	 */ 
	public void setAddress(String address){
		this.address=address;
	}
	/**
	 * @Title:setAddress 
	 * @Description: TODO(得到Address	安装位置)
	 * @return String
	 */ 
	public String getAddress(){
		return address;
	}
	/**
	 * @Title:toString 
	 * @Description: TODO(toString)
	 */ 
	public String toString() { 
		return "DeviceGroup[id=" + id + ",groupName=" + groupName + ",address=" + address + "]";
	}
}

