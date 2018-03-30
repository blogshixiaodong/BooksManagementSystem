package com.bms.dao;

import java.sql.SQLException;
import java.util.List;
import com.bms.bean.Record;

public interface IRecordDao  {
	
	//添加纪录
	boolean addRecord(Integer uid,Integer bid) throws SQLException;
	
	//归还图书
	boolean updateRecord(Integer id) throws SQLException;
	
	//已借图书数量
	Integer borrowBookCount(Integer uid) throws SQLException;
	
	//获取已借图书记录
	List<Object[]> getRecordByUserId(Integer id) throws SQLException;
	
	//这本书借阅时间
	int borrowTime(Integer uid, Integer bid) throws SQLException;
	
	//是否有超期图书
	boolean hasOverTimeBook(Integer uid) throws SQLException;
}
