package com.common.pojo;

import java.io.Serializable;

/**
 * @ClassName:radiotube_device 
 * @Description: TODO(类说明：电磁阀设备 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class RadiotubeDevice implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id; 	//ID
	private String radiotubeNumber; 	//设备编号
	private String radiotubeName; 	//设备名称
	private Integer dictId; 	//设备类型
	private String createTime; 	//创建时间
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public RadiotubeDevice(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param id	ID
	 * @param radiotubeNumber	设备编号
	 * @param radiotubeName	设备名称
	 * @param dictId	设备类型
	 * @param createTime	创建时间
	 */ 
	public RadiotubeDevice(Integer id,String radiotubeNumber,String radiotubeName,Integer dictId,String createTime){
		this.id=id;
		this.radiotubeNumber=radiotubeNumber;
		this.radiotubeName=radiotubeName;
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
	 * @Title:setRadiotubeNumber 
	 * @Description: TODO(设置RadiotubeNumber	设备编号)
	 * @param radiotubeNumber
	 */ 
	public void setRadiotubeNumber(String radiotubeNumber){
		this.radiotubeNumber=radiotubeNumber;
	}
	/**
	 * @Title:setRadiotubeNumber 
	 * @Description: TODO(得到RadiotubeNumber	设备编号)
	 * @return String
	 */ 
	public String getRadiotubeNumber(){
		return radiotubeNumber;
	}
	/**
	 * @Title:setRadiotubeName 
	 * @Description: TODO(设置RadiotubeName	设备名称)
	 * @param radiotubeName
	 */ 
	public void setRadiotubeName(String radiotubeName){
		this.radiotubeName=radiotubeName;
	}
	/**
	 * @Title:setRadiotubeName 
	 * @Description: TODO(得到RadiotubeName	设备名称)
	 * @return String
	 */ 
	public String getRadiotubeName(){
		return radiotubeName;
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
		return "RadiotubeDevice[id=" + id + ",radiotubeNumber=" + radiotubeNumber + ",radiotubeName=" + radiotubeName + ","+
		"dictId=" + dictId + ",createTime=" + createTime + "]";
	}
}

