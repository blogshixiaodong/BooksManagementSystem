package com.bms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*
 * date:   2018年3月24日 上午12:19:36
 * author: Shixiaodong
 */
public interface IPageDao<T> {
	static final int DEFAULT_PAGE_SIZE = 5;

	default int getPageSize() {
		return DEFAULT_PAGE_SIZE;
	}
	int  getRecordCount() throws SQLException;
	List<T> getRecordByPageNo(int currentPageNo) throws SQLException;

}
