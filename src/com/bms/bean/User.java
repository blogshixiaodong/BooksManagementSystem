package com.bms.bean;

import java.io.Serializable;


/**
 *  date : 2018年3月25日	
 * author: jiangjiamin
 * 
 */
public class User implements Serializable{
	/**
	 * 
	 */
	
	private Integer uid;
	private String username;
	private String password;
	private String sex;
	private Integer age;
	private Float balance;
	private Integer is_freeze;
	
	
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public Integer getIs_freeze() {
		return is_freeze;
	}
	public void setIs_freeze(int is_freeze) {
		this.is_freeze = is_freeze;
	}
	
	
	
	
}
