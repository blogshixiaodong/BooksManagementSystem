package com.bms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *  date : 2018年3月25日	
 * author: jiangjiamin
 * 
 */
public class Book implements Serializable{
	/**
	 * 
	 */
	
	private Integer bid;
	private String bname;
	private String author;
	private String press;     //出版社
	private Date publishTime; //出版时间
	private Integer stock;        //库存
	
	
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	
	
}
