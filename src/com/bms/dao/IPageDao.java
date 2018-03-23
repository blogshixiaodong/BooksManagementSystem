package com.bms.dao;

import java.util.List;

/*
 * date:   2018年3月24日 上午12:19:36
 * author: Shixiaodong
 */
public interface IPageDao<T> {
	static final int DEFAULT_PAGE_SIZE = 5;

	int getRecordCount();

	List<T> getRecordByPageNo(int pageNo);

}
