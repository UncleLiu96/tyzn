package com.tyzn.pojo;

import java.io.Serializable;

/**
 * @ClassName:dictionaries 
 * @Description: TODO(类说明：字典 )
 * @author Uncle liu 
 * @date 2019-08-29 16:11:05
 */ 
public class Dictionaries implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id; 	//ID
	private String dictTitle; 	//标题
	private String dictSign; 	//标记
	private String dictType; 	//类型
	private String dictCode; 	//编号
	/**
	 * @Description: TODO(无参构造方法) 
	 */ 
	public Dictionaries(){
	}
	/**
	 * @Description: TODO(有参构造方法) 
	 * @param id	ID
	 * @param dictTitle	标题
	 * @param dictSign	标记
	 * @param dictType	类型
	 * @param dictCode	编号
	 */ 
	public Dictionaries(Integer id,String dictTitle,String dictSign,String dictType,String dictCode){
		this.id=id;
		this.dictTitle=dictTitle;
		this.dictSign=dictSign;
		this.dictType=dictType;
		this.dictCode=dictCode;
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
	 * @Title:setDictTitle 
	 * @Description: TODO(设置DictTitle	标题)
	 * @param dictTitle
	 */ 
	public void setDictTitle(String dictTitle){
		this.dictTitle=dictTitle;
	}
	/**
	 * @Title:setDictTitle 
	 * @Description: TODO(得到DictTitle	标题)
	 * @return String
	 */ 
	public String getDictTitle(){
		return dictTitle;
	}
	/**
	 * @Title:setDictSign 
	 * @Description: TODO(设置DictSign	标记)
	 * @param dictSign
	 */ 
	public void setDictSign(String dictSign){
		this.dictSign=dictSign;
	}
	/**
	 * @Title:setDictSign 
	 * @Description: TODO(得到DictSign	标记)
	 * @return String
	 */ 
	public String getDictSign(){
		return dictSign;
	}
	/**
	 * @Title:setDictType 
	 * @Description: TODO(设置DictType	类型)
	 * @param dictType
	 */ 
	public void setDictType(String dictType){
		this.dictType=dictType;
	}
	/**
	 * @Title:setDictType 
	 * @Description: TODO(得到DictType	类型)
	 * @return String
	 */ 
	public String getDictType(){
		return dictType;
	}
	/**
	 * @Title:setDictCode 
	 * @Description: TODO(设置DictCode	编号)
	 * @param dictCode
	 */ 
	public void setDictCode(String dictCode){
		this.dictCode=dictCode;
	}
	/**
	 * @Title:setDictCode 
	 * @Description: TODO(得到DictCode	编号)
	 * @return String
	 */ 
	public String getDictCode(){
		return dictCode;
	}
	/**
	 * @Title:toString 
	 * @Description: TODO(toString)
	 */ 
	public String toString() { 
		return "Dictionaries[id=" + id + ",dictTitle=" + dictTitle + ",dictSign=" + dictSign + ","+
		"dictType=" + dictType + ",dictCode=" + dictCode + "]";
	}
}

