package com.bms.server;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.Record;

/**
 *  date : 2018��3��25��	
 * author: jiangjiamin
 * 
 */
public interface IRecordServer {
	//添加借阅记录
	String addRecord(Integer uid,Integer bid);
	
	//归还图书
	boolean returnBook(Integer bid,Integer uid,Integer rid);

	//获取记录信息
	List<Object[]> getRecordByUserId(Integer id);
	
	//检查冻结状态
	void checkUserFreezeStatus(Integer uid);
	
	//历史借阅记录
	List<Object[]> getHistoryRecordByUserId(Integer uid);
}
