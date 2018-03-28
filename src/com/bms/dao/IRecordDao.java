package com.bms.dao;

import java.sql.SQLException;
import java.util.List;
import com.bms.bean.Record;

public interface IRecordDao  {
	
	
	boolean addRecord(Integer uid,Integer bid) throws SQLException;
	
	
	boolean isReturnBook(String id) throws SQLException;
	
	boolean updateRecord(Integer id) throws SQLException;

	List<Record> getRecord() throws SQLException;
	
	List<Record> getRecordByUserId(Integer id) throws SQLException;
}
