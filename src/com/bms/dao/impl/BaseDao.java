package com.bms.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bms.dao.IBaseDao;

/*
 * date:   2018年3月23日 下午11:39:28
 * author: Shixiaodong
 */
public class BaseDao implements IBaseDao {
	protected Connection connection;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeQuickly() {
		// TODO Auto-generated method stub
		
	}
	
}
