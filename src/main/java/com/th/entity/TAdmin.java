package com.th.entity;

import java.io.Serializable;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class TAdmin implements Serializable{

	  private static final long serialVersionUID = 1L;
	
      //用户主键id
	  private Integer id;
      //用户名
	  private String username;
      //密码
	  private String password;

	  /**
	   * 设置：用户主键id
	   */
	  public void setId(Integer id) {
		  this.id = id;
	  }
	  /**
	   * 获取：用户主键id
	   */
	  public Integer getId() {
	   	  return id;
	  }
	  /**
	   * 设置：用户名
	   */
	  public void setUsername(String username) {
		  this.username = username;
	  }
	  /**
	   * 获取：用户名
	   */
	  public String getUsername() {
	   	  return username;
	  }
	  /**
	   * 设置：密码
	   */
	  public void setPassword(String password) {
		  this.password = password;
	  }
	  /**
	   * 获取：密码
	   */
	  public String getPassword() {
	   	  return password;
	  }

	 
	  @Override
	  public String toString() {
		  return  ReflectionToStringBuilder.toString(this);
	  }

}
