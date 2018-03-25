package com.bms.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bms.bean.User;
import com.bms.dao.IUserDao;
import com.mysql.jdbc.Statement;

/*
 * date:   2018骞�3鏈�24鏃� 涓婂崍12:16:48
 * author: Shixiaodong
 */
public class UserDaoImpl extends BaseDao implements IUserDao {

	@Override
	public int addUser(User user) throws SQLException {
		int result = -1;
		String sql = "INSERT INTO user VALUES(null, ?, ?)";
		pstmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
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
		String sql = "UPDATE user SET username = ? and password = ? WHERE uid = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setInt(3, user.getUid());
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
		closeQuickly();
		return user;
	}

	
	
}
