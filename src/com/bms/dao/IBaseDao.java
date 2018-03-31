package com.bms.dao;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * date:   2018/3/23
 * author: Shixiaodong
 */
public interface IBaseDao {
	public abstract Connection getConnection();
	public abstract void close() throws SQLException;
	public abstract void closeQuickly();
}
