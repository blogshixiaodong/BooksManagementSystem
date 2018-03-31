package com.bms.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.bms.dao.IBaseDao;
import com.sxd.util.jdbc.IDataBase;
import com.sxd.util.jdbc.JdbcUtils;

/*
 * date:   2018/3/23
 * author: Shixiaodong
 */
public class BaseDao implements IBaseDao {
	protected Connection connection;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	private IDataBase dataBase;
	
	public synchronized Connection getConnection() {
		try {
			if(connection != null && !connection.isClosed()) {
				return connection;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dataBase = JdbcUtils.newInstance();
		return dataBase.getConnection();
		
	}
	
	public void closeConnection() throws SQLException {
		if(connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
	
	public void closeStatement() throws SQLException {
		if(stmt != null && !stmt.isClosed()) {
			stmt.close();
		}
	}
	
	public void closePrepareStatement() throws SQLException {
		if(pstmt != null && !pstmt.isClosed()) {
			pstmt.close();
		}
	}
	
	//com.mysql.jdbc.ResultSet娌℃湁瀹炵幇isClose鎺ュ彛
	public void closeResultSet() throws SQLException {
		if(rs != null) {
			rs.close();
		}
	}

	@Override
	public void close() throws SQLException {
		closeResultSet();
		closeStatement();
		closePrepareStatement();
		closeConnection();
	}

	@Override
	public void closeQuickly() {
		try {
			closeResultSet();
			closeStatement();
			closePrepareStatement();
			closeConnection();
		} catch (SQLException e) {
		
		}
	}

	
	
}
