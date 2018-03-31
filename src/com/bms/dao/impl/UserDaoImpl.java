package com.bms.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bms.bean.User;
import com.bms.dao.IUserDao;
import com.mysql.jdbc.Statement;


/**
 *  date : 2018年3月25日	
 * author: jiangjiamin
 * 
 */
public class UserDaoImpl extends BaseDao implements IUserDao {

	@Override
	public int addUser(User user) throws SQLException {
		int result = -1;
		String sql = "INSERT INTO user VALUES(null, ?, ?, ?, ?, 1, 0)";
		pstmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getSex());
		pstmt.setInt(4, user.getAge());
		result = pstmt.executeUpdate();
		if(result > 0) {
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}
		closeQuickly();
		return result;
	}

	@Override
	public boolean deleteUser(Integer id) throws SQLException {
		boolean result = false;
		String sql = "DELETE FROM user WHERE uid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		result = pstmt.executeUpdate() == 1;
		closeQuickly();
		return result;
	}

	

	@Override
	public boolean updateUser(User user) throws SQLException {
		boolean result = false;
		String sql = "UPDATE user SET username = ?, sex = ?, age = ? WHERE uid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		
		pstmt.setString(2, user.getSex());
		pstmt.setInt(3, user.getAge());
//		pstmt.setFloat(4, user.getBalance());
		pstmt.setInt(4, user.getUid());
		result = pstmt.executeUpdate() == 1;
		closeQuickly();
		return result;
	}
	
	@Override
	public boolean updatePassword(int uid, String password) throws SQLException {
		boolean result = false;
		String sql = "UPDATE user SET password = ? WHERE uid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, password);
		pstmt.setInt(2, uid);
		result = pstmt.executeUpdate() == 1;
		closeQuickly();
		return result;
	}

	@Override
	public boolean isExistUser(Integer id) throws SQLException {
		boolean result = false;
		String sql = "SELECT COUNT(*) FROM user WHERE uid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			if(rs.getInt(1) > 0) {
				result = true;
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		closeQuickly();
		return result;
	}

	

	@Override
	public List<User> getUserList() throws SQLException {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM user";
		pstmt = getConnection().prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setUid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setSex(rs.getString(4));
			user.setAge(rs.getInt(5));
			user.setBalance(rs.getFloat(6));
			user.setIs_freeze(rs.getInt(7));
			list.add(user);
		}
		closeQuickly();
		return list;
	}
	
	//getUserById不对id的存在做判断，使用前调用isExistUser
	@Override
	public User getUserById(Integer id) throws SQLException {
		User user = new User();
		String sql = "SELECT * FROM user WHERE uid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		rs.next();
		user.setUid(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setPassword(rs.getString(3));
		user.setSex(rs.getString(4));
		user.setAge(rs.getInt(5));
		user.setBalance(rs.getFloat(6));
		user.setIs_freeze(rs.getInt(7));
		closeQuickly();
		return user;
	}

	@Override
	public boolean isFreeze(Integer id) throws SQLException {
		String sql = "SELECT is_freeze FROM user WHERE uid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		rs.next();
		int is_freeze = rs.getInt(1);
		closeQuickly();
		if(is_freeze == 1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBalance(Integer uid, Float money) throws SQLException {
		boolean result = false;
		String sql = "UPDATE user SET balance = balance + ? WHERE uid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setFloat(1, money);
		pstmt.setInt(2, uid);
		result = pstmt.executeUpdate() == 1;
		closeQuickly();
		return result;
	}
	
	@Override
	public List<User> getRecordByPageNo(int currentPageNo) throws SQLException {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM user" + " limit " + (currentPageNo - 1) + "," + getRecordCount();
		pstmt = getConnection().prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			User user = new User();
			user.setUid(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setSex(rs.getString(4));
			user.setAge(rs.getInt(5));
			user.setBalance(rs.getFloat(6));
			user.setIs_freeze(rs.getInt(7));
			list.add(user);
		}
		closeQuickly();
		return list;
	}
	
	@Override
	public int getRecordCount() throws SQLException {
		String sql = "SELECT COUNT(*) FROM user";
		pstmt = getConnection().prepareStatement(sql);
		rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		closeQuickly();
		return count;
	}

	@Override
	public boolean updateStatus(Integer uid, Integer is_freeze) throws SQLException {
		boolean result = false;
		String sql = "UPDATE user SET is_freeze = ? WHERE uid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, is_freeze);
		pstmt.setInt(2, uid);
		result = pstmt.executeUpdate() == 1;
		closeQuickly();
		return result;
	}
	
	
	
}
