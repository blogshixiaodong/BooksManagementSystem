package com.bms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.Record;
import com.bms.dao.IRecordDao;

public class RecordDaoImpl implements IRecordDao {

	@Override
	public boolean addRecord(Record record) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReturnBook(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRecord(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Record> getRecord() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Record> getRecordByUserId(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
