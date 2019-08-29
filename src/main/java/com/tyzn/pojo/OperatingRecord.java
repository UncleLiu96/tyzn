package com.tyzn.pojo;

import java.io.Serializable;

/**
 * @ClassName:operating_record 
 * @Description: TODO(类说明：操作日志 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class OperatingRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id; 	//ID
	private String operationalContext; 	//操作记录
	private Integer isSuccess; 	//是否成功
	private Integer operationalUser; 	//操作用户
	private String createTime; 	//创建时间
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public OperatingRecord(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param id	ID
	 * @param operationalContext	操作记录
	 * @param isSuccess	是否成功
	 * @param operationalUser	操作用户
	 * @param createTime	创建时间
	 */ 
	public OperatingRecord(Integer id,String operationalContext,Integer isSuccess,Integer operationalUser,String createTime){
		this.id=id;
		this.operationalContext=operationalContext;
		this.isSuccess=isSuccess;
		this.operationalUser=operationalUser;
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
	 * @Title:setOperationalContext 
	 * @Description: TODO(设置OperationalContext	操作记录)
	 * @param operationalContext
	 */ 
	public void setOperationalContext(String operationalContext){
		this.operationalContext=operationalContext;
	}
	/**
	 * @Title:setOperationalContext 
	 * @Description: TODO(得到OperationalContext	操作记录)
	 * @return String
	 */ 
	public String getOperationalContext(){
		return operationalContext;
	}
	/**
	 * @Title:setIsSuccess 
	 * @Description: TODO(设置IsSuccess	是否成功)
	 * @param isSuccess
	 */ 
	public void setIsSuccess(Integer isSuccess){
		this.isSuccess=isSuccess;
	}
	/**
	 * @Title:setIsSuccess 
	 * @Description: TODO(得到IsSuccess	是否成功)
	 * @return Integer
	 */ 
	public Integer getIsSuccess(){
		return isSuccess;
	}
	/**
	 * @Title:setOperationalUser 
	 * @Description: TODO(设置OperationalUser	操作用户)
	 * @param operationalUser
	 */ 
	public void setOperationalUser(Integer operationalUser){
		this.operationalUser=operationalUser;
	}
	/**
	 * @Title:setOperationalUser 
	 * @Description: TODO(得到OperationalUser	操作用户)
	 * @return Integer
	 */ 
	public Integer getOperationalUser(){
		return operationalUser;
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
		return "OperatingRecord[id=" + id + ",operationalContext=" + operationalContext + ",isSuccess=" + isSuccess + ","+
		"operationalUser=" + operationalUser + ",createTime=" + createTime + "]";
	}
}

