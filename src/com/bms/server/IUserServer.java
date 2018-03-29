package com.bms.server;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.User;

/*
 * date:   2018年3月23日 下午11:57:55
 * author: Shixiaodong
 */
public interface IUserServer {
	
	int registerUser(User user);

	boolean deleteUser(Integer id);

	boolean updateUser(User user);
	
	boolean updatePassword(int uid, String password);

	boolean isExistUser(Integer id);

	List<User> getUserList();

	User getUserById(Integer id);
	
	boolean login(int uid, String password);
	
	boolean isFreeze(Integer id);
	
	boolean updateBalance(Integer uid, int money);
	
	
}
