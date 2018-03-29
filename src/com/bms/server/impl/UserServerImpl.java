package com.bms.server.impl;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.User;
import com.bms.dao.IUserDao;
import com.bms.dao.impl.UserDaoImpl;
import com.bms.server.IUserServer;

/*
 * date:   2018年3月24日 上午12:00:43
 * author: Shixiaodong
 */
public class UserServerImpl implements IUserServer {

	private IUserDao dao = new UserDaoImpl();
	
	@Override
	public int registerUser(User user) {
		try {
			int id = dao.addUser(user);
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public boolean deleteUser(Integer id) {
		try {
			return dao.deleteUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

	@Override
	public boolean updatePassword(int uid, String password) {
		try {
			return dao.updatePassword(uid, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		try {
			return dao.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isExistUser(Integer id) {
		try {
			return dao.isExistUser(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> getUserList() {
		try {
			return dao.getUserList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserById(Integer id) {
		try {
			if(!isExistUser(id)) {
				return null;
			}
			return dao.getUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean login(int uid, String password) {
		try {
			if(!dao.isExistUser(uid)) {
				return false;
			} else {
				User user = dao.getUserById(uid);
				if(!user.getPassword().equals(password)) {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean isFreeze(Integer id) {
		try {
			return dao.isFreeze(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateBalance(Integer uid, Float money) {
		try {
			return dao.updateBalance(uid, money);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
}
