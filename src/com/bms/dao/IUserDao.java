package com.bms.dao;

import java.util.List;

import com.bms.bean.User;

/*
 * date:   2018年3月23日 下午11:43:31
 * author: Shixiaodong
 */
public interface IUserDao {
	boolean addUser(User user);

	boolean deleteUser(String id);

	boolean updateUser(String id);

	boolean isExistUser(String id);

	List<User> getUserList();

	User getUserById(String id);
}
