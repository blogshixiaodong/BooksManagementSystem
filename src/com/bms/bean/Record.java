package com.bms.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *  date : 2018Äê3ÔÂ25ÈÕ	
 * author: jiangjiamin
 * 
 */
public class Record implements Serializable{
	private Integer rid;
	private Integer uid;
	private Integer bid;
	private Date borrowTime;
	private Date returnTime;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Date getBorrowTime() {
		return borrowTime;
	}
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	
}
