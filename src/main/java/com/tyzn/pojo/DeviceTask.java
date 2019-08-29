package com.tyzn.pojo;

import java.io.Serializable;

/**
 * @ClassName:device_task 
 * @Description: TODO(类说明：电磁阀设备与定时任务关系表 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class DeviceTask implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer rId; 	//电磁阀id
	private Integer tId; 	//定时任务id
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public DeviceTask(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param rId	电磁阀id
	 * @param tId	定时任务id
	 */ 
	public DeviceTask(Integer rId,Integer tId){
		this.rId=rId;
		this.tId=tId;
	}
	/**
	 * @Title:setRId 
	 * @Description: TODO(设置RId	电磁阀id)
	 * @param rId
	 */ 
	public void setRId(Integer rId){
		this.rId=rId;
	}
	/**
	 * @Title:setRId 
	 * @Description: TODO(得到RId	电磁阀id)
	 * @return Integer
	 */ 
	public Integer getRId(){
		return rId;
	}
	/**
	 * @Title:setTId 
	 * @Description: TODO(设置TId	定时任务id)
	 * @param tId
	 */ 
	public void setTId(Integer tId){
		this.tId=tId;
	}
	/**
	 * @Title:setTId 
	 * @Description: TODO(得到TId	定时任务id)
	 * @return Integer
	 */ 
	public Integer getTId(){
		return tId;
	}
	/**
	 * @Title:toString 
	 * @Description: TODO(toString)
	 */ 
	public String toString() { 
		return "DeviceTask[rId=" + rId + ",tId=" + tId + "]";
	}
}

