package com.th.entity;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class TPhonebook implements Serializable{

	  private static final long serialVersionUID = 1L;
	
      //联系人id
	  private Integer id;
      //联系人姓名
	  private String name;
      //手机号码
	  private String phonenumber;
      //座机电话号码
	  private String telenumber;
      //工作单位地址
	  private String workaddress;
      //家庭地址
	  private String homeaddress;
      //头像
	  private String image;
      //备注其他
	  private String remark;
      //姓名首字母
	  private String initial;

	  /**
	   * 设置：联系人id
	   */
	  public void setId(Integer id) {
		  this.id = id;
	  }
	  /**
	   * 获取：联系人id
	   */
	  public Integer getId() {
	   	  return id;
	  }
	  /**
	   * 设置：联系人姓名
	   */
	  public void setName(String name) {
		  this.name = name;
	  }
	  /**
	   * 获取：联系人姓名
	   */
	  public String getName() {
	   	  return name;
	  }
	  /**
	   * 设置：手机号码
	   */
	  public void setPhonenumber(String phonenumber) {
		  this.phonenumber = phonenumber;
	  }
	  /**
	   * 获取：手机号码
	   */
	  public String getPhonenumber() {
	   	  return phonenumber;
	  }
	  /**
	   * 设置：座机电话号码
	   */
	  public void setTelenumber(String telenumber) {
		  this.telenumber = telenumber;
	  }
	  /**
	   * 获取：座机电话号码
	   */
	  public String getTelenumber() {
	   	  return telenumber;
	  }
	  /**
	   * 设置：工作单位地址
	   */
	  public void setWorkaddress(String workaddress) {
		  this.workaddress = workaddress;
	  }
	  /**
	   * 获取：工作单位地址
	   */
	  public String getWorkaddress() {
	   	  return workaddress;
	  }
	  /**
	   * 设置：家庭地址
	   */
	  public void setHomeaddress(String homeaddress) {
		  this.homeaddress = homeaddress;
	  }
	  /**
	   * 获取：家庭地址
	   */
	  public String getHomeaddress() {
	   	  return homeaddress;
	  }
	  /**
	   * 设置：头像
	   */
	  public void setImage(String image) {
		  this.image = image;
	  }
	  /**
	   * 获取：头像
	   */
	  public String getImage() {
	   	  return image;
	  }
	  /**
	   * 设置：备注其他
	   */
	  public void setRemark(String remark) {
		  this.remark = remark;
	  }
	  /**
	   * 获取：备注其他
	   */
	  public String getRemark() {
	   	  return remark;
	  }
	  /**
	   * 设置：姓名首字母
	   */
	  public void setInitial(String initial) {
		  this.initial = initial;
	  }
	  /**
	   * 获取：姓名首字母
	   */
	  public String getInitial() {
	   	  return initial;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
