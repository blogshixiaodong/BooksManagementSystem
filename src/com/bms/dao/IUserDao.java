package com.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.User;

/*
 * date:   2018骞�3鏈�23鏃� 涓嬪崍11:43:31
 * author: Shixiaodong
 */
public interface IUserDao {
	int addUser(User user) throws SQLException;

	boolean deleteUser(Integer id) throws SQLException;

	boolean updateUser(User user) throws SQLException;

	boolean isExistUser(Integer id) throws SQLException;

	List<User> getUserList() throws SQLException;

	User getUserById(Integer id) throws SQLException;
}
