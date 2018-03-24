package com.bms.dao;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * date:   2018年3月23日 下午11:39:57
 * author: Shixiaodong
 */
public interface IBaseDao {
	public abstract Connection getConnection();
	public abstract void close() throws SQLException;
	public abstract void closeQuickly();
}
