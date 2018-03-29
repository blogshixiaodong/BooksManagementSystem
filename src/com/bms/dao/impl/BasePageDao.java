package com.bms.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bms.dao.IPageDao;

/*
 * date:   2018年3月24日 上午12:26:44
 * author: Shixiaodong
 */
public abstract class BasePageDao<T> extends BaseDao implements IPageDao<T> {
	
	private int pageSize = 0;

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public int getRecordCount() {

		return 0;
	}
	
	public abstract String getSelectString();
	
	@Override
	public List<T> getRecordByPageNo(int pageNo) throws SQLException {
		return null;
	}

}
