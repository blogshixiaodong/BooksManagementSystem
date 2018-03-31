package com.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.User;

/*
 * date:   2018/3/31
 * author: Shixiaodong
 */
public interface IUserDao extends IPageDao<User> {
	int addUser(User user) throws SQLException;

	boolean deleteUser(Integer id) throws SQLException;

	boolean updateUser(User user) throws SQLException;

	boolean isExistUser(Integer id) throws SQLException;

	List<User> getUserList() throws SQLException;

	User getUserById(Integer id) throws SQLException;
	
	boolean updatePassword(int uid, String password) throws SQLException;
	
	boolean isFreeze(Integer id)  throws SQLException;
	
	boolean updateBalance(Integer uid, Float money)  throws SQLException;
	
	boolean updateStatus(Integer uid, Integer is_freeze) throws SQLException;
}
