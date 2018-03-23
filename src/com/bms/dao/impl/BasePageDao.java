package com.bms.dao.impl;

import java.util.List;

import com.bms.dao.IPageDao;

/*
 * date:   2018年3月24日 上午12:26:44
 * author: Shixiaodong
 */
public abstract class BasePageDao<T> extends BaseDao implements IPageDao<T> {
	
	
	public abstract String getTableName();
	
	@Override
	public int getRecordCount() {

		return 0;
	}

	@Override
	public List<T> getRecordByPageNo(int pageNo) {
		
		return null;
	}

}
