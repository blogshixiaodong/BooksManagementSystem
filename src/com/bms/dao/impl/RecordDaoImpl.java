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
	
	
	//归还图书， 修改归还时间
	@Override
	public boolean updateRecord(Integer rid) throws SQLException {
		String sql = "UPDATE RECORD SET RETURNTIME = ? WHERE rid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, DateFormat.dateToString(new Date()));
		pstmt.setInt(2, rid);
		return pstmt.executeUpdate() == 1;
	}
	
		/*//查询用户未归还图书记录
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
		}*/
	
			//查询用户未归还图书记录
			@Override
			public List<Object[]> getRecordByUserId(Integer uid) throws SQLException {
				String sql = "SELECT RECORD.BID,RID,BNAME,AUTHOR,PRESS,BORROWTIME,TIMESTAMPDIFF(DAY,BORROWTIME,NOW()) DAY FROM RECORD,BOOK"
						+ " WHERE BOOK.BID = RECORD.BID AND UID = ? AND RETURNTIME IS NULL";
				pstmt = getConnection().prepareStatement(sql);
				pstmt.setInt(1, uid);
				rs = pstmt.executeQuery();
				List<Object[]> recordlist = new ArrayList<Object[]>();
				
				while(rs.next()) {
					Object[] objects =  new Object[7];
					objects[0] = rs.getString("BNAME");
					objects[1] = rs.getString("AUTHOR");
					objects[2] = rs.getString("PRESS");
					objects[3] = rs.getString("BORROWTIME");
					objects[4] = rs.getInt("DAY");
					objects[5] = rs.getInt("RECORD.BID");
					objects[6] = rs.getInt("RID");
					recordlist.add(objects);
				}
				return recordlist;
			}
	
	//根据用户id 查询共借多少图书
	@Override
	public Integer borrowBookCount(Integer uid) throws SQLException {
		String sql = "SELECT COUNT(*) COUNT FROM RECORD WHERE UID = ? AND RETURNTIME IS NULL";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		/*if(rs.next()) {
			Integer count = rs.getInt("count");
		}*/
		rs.next();
		return rs.getInt("count");
		
	}

	/*是否有超期图书   
	 * 有超期 返回true
	 * */
	@Override
	public boolean hasOverTimeBook(Integer uid) throws SQLException {
		String sql = "SELECT  COUNT(*) NUM FROM RECORD WHERE RETURNTIME IS NULL AND UID = ? AND TIMESTAMPDIFF(DAY,BORROWTIME,NOW())>60";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		rs.next();
		Integer count = rs.getInt("NUM");
		if(count != 0) {
			return true;
		}
		
		return false;
	}
	
	
	/*该书是否超期   
	 * 有超期 返回true
	 * */
	public int borrowTime(Integer uid, Integer bid) throws SQLException {

		String sql = "SELECT TIMESTAMPDIFF(DAY,BORROWTIME,NOW()) NUM FROM RECORD WHERE RETURNTIME IS NULL AND UID = ? AND BID = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, uid);
		pstmt.setInt(2, bid);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt("NUM");
		}
		return -1;
	}


	@Override
	public List<Record> getRecord() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	

}
