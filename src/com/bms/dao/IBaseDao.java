package com.bms.dao;

import java.sql.Connection;

/*
 * date:   2018年3月23日 下午11:39:57
 * author: Shixiaodong
 */
public interface IBaseDao {
	public abstract Connection getConnection();
	public abstract void close();
	public abstract void closeQuickly();
}
