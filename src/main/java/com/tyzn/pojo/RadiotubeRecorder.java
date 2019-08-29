package com.tyzn.pojo;

import java.io.Serializable;

/**
 * @ClassName:radiotube_recorder 
 * @Description: TODO(类说明：电磁阀开关记录 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class RadiotubeRecorder implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id; 	//ID
	private Integer onOff; 	//开：1  关：0
	private String createTime; 	//创建时间
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public RadiotubeRecorder(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param id	ID
	 * @param onOff	开：1  关：0
	 * @param createTime	创建时间
	 */ 
	public RadiotubeRecorder(Integer id,Integer onOff,String createTime){
		this.id=id;
		this.onOff=onOff;
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
	 * @Title:setOnOff 
	 * @Description: TODO(设置OnOff	开：1  关：0)
	 * @param onOff
	 */ 
	public void setOnOff(Integer onOff){
		this.onOff=onOff;
	}
	/**
	 * @Title:setOnOff 
	 * @Description: TODO(得到OnOff	开：1  关：0)
	 * @return Integer
	 */ 
	public Integer getOnOff(){
		return onOff;
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
		return "RadiotubeRecorder[id=" + id + ",onOff=" + onOff + ",createTime=" + createTime + "]";
	}
}

