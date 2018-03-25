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
	boolean addRecord(Record record) throws SQLException;
	
	
	boolean isReturnBook(String id) throws SQLException;
	
	boolean updateRecord(Integer id) throws SQLException;

	List<Record> getRecord() throws SQLException;
	
	List<Record> getRecordByUserId(Integer id) throws SQLException;
}
