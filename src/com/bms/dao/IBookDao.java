package com.bms.dao;

import java.sql.SQLException;
import java.util.List;
import com.bms.bean.Book;

/**
 *  date : 2018年3月25日	
 * author: jiangjiamin
 * 
 */
public interface IBookDao extends IPageDao<Book> {
	boolean addBook(Book book) throws SQLException;

	boolean deleteBook(Integer id) throws SQLException;

	boolean updateBook(Book book) throws SQLException;
	
	boolean isExistBook(Integer id) throws SQLException;
	
	boolean hasStock(Integer bid)throws SQLException;
	
	boolean updateStock(Integer bid,String flag)throws SQLException;

	Book getBookById(Integer id) throws SQLException;
	
	List<Integer> getBookIdList() throws SQLException;

	List<Book> getBookList() throws SQLException;
	
	List<Book> getBookByConndition(String conndition) throws SQLException;
	
	
	
}
