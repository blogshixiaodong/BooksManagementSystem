package com.bms.server;


import java.util.List;

/**
 *  date : 2018��3��25��	
 * author: jiangjiamin
 * 
 */
public interface IRecordServer {
	String addRecord(Integer uid,Integer bid);
	
	boolean returnBook(Integer bid,Integer uid,Integer rid);

	
	List<Object[]> getRecordByUserId(Integer id);
}
