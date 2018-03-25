package com.bms.dao;

import java.util.List;

import com.bms.bean.User;

/*
 * date:   2018骞�3鏈�23鏃� 涓嬪崍11:43:31
 * author: Shixiaodong
 */
public interface IUserDao {
	boolean addUser(User user);

	boolean deleteUser(Integer id);

	boolean updateUser(User user);

	boolean isExistUser(Integer id);

	List<User> getUserList();

	User getUserById(String id);
}
