package com.common.pojo;

import java.io.Serializable;

/**
 * @ClassName:timed_task 
 * @Description: TODO(类说明：定时任务 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class TimedTask implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id; 	//ID
	private String taskName; 	//名称
	private String timeQuantum; 	//时间段
	private String createTime; 	//创建时间
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public TimedTask(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param id	ID
	 * @param taskName	名称
	 * @param timeQuantum	时间段
	 * @param createTime	创建时间
	 */ 
	public TimedTask(Integer id,String taskName,String timeQuantum,String createTime){
		this.id=id;
		this.taskName=taskName;
		this.timeQuantum=timeQuantum;
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
	 * @Title:setTaskName 
	 * @Description: TODO(设置TaskName	名称)
	 * @param taskName
	 */ 
	public void setTaskName(String taskName){
		this.taskName=taskName;
	}
	/**
	 * @Title:setTaskName 
	 * @Description: TODO(得到TaskName	名称)
	 * @return String
	 */ 
	public String getTaskName(){
		return taskName;
	}
	/**
	 * @Title:setTimeQuantum 
	 * @Description: TODO(设置TimeQuantum	时间段)
	 * @param timeQuantum
	 */ 
	public void setTimeQuantum(String timeQuantum){
		this.timeQuantum=timeQuantum;
	}
	/**
	 * @Title:setTimeQuantum 
	 * @Description: TODO(得到TimeQuantum	时间段)
	 * @return String
	 */ 
	public String getTimeQuantum(){
		return timeQuantum;
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
		return "TimedTask[id=" + id + ",taskName=" + taskName + ",timeQuantum=" + timeQuantum + ","+
		"createTime=" + createTime + "]";
	}
}

