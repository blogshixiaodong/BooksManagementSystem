package com.bms.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bms.bean.Record;
import com.bms.dao.IRecordDao;
import com.utils.DateFormat;

/**
 *  date : 2018年3月28日	
 * 	author: jiangjiamin
 * 
 */
public class RecordDaoImpl extends BaseDao implements IRecordDao {

	@Override
	public boolean addRecord(Integer uid,Integer bid) throws SQLException {
		String sql = "INSERT INTO RECORD(UID,BID,BORROWTIME)VALUES(?,?,?)";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1,uid);
		pstmt.setInt(2, bid);
		pstmt.setString(3, DateFormat.dateToString(new Date()));
		return pstmt.executeUpdate() == 1;
	}

	@Override
	public boolean isReturnBook(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	//归还图书， 修改归还时间
	@Override
	public boolean updateRecord(Integer rid) throws SQLException {
		String sql = "UPDATE RECORD SET RETURNTIME = ? WHERE rid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, DateFormat.dateToString(new Date()));
		pstmt.setInt(2, rid);
		return pstmt.executeUpdate() == 1;
		
	}

	@Override
	public List<Record> getRecord() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//查询用户未归还图书记录
	@Override
	public List<Record> getRecordByUserId(Integer uid) throws SQLException {
		String sql = "SELECT * FROM RECORD WHERE UID = ? AND RETURNTIME IS NULL";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		List<Record> recordlist = new ArrayList<Record>();
		
		while(rs.next()) {
			Record record = new Record();
			record.setBid(rs.getInt("bid"));
			record.setRid(rs.getInt("rid"));
			record.setBorrowTime(rs.getDate("borrowTime"));
			recordlist.add(record);
		}
		return recordlist;
	}

}
