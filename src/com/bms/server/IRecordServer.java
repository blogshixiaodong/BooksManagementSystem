package com.bms.server;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.Record;

/**
 *  date : 2018��3��25��	
 * author: jiangjiamin
 * 
 */
public interface IRecordServer {
	boolean addRecord(Integer uid,Integer bid);
	
	public boolean returnBook(Integer bid,Integer uid,Integer rid);

	
	List<Object[]> getRecordByUserId(Integer id);
}
