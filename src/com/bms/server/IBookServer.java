package com.bms.server;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.Book;
import com.bms.exception.BookException;

/**
 *  date : 2018��3��25��	
 * author: jiangjiamin
 * 
 */
public interface IBookServer {
	boolean addBook(Book book) throws BookException;

	boolean deleteBook(Integer id);

	boolean updateBook(Book Book) throws BookException;
	
	boolean isExistBook(Integer id);

	Book getBookById(Integer id);
	
	List<Integer> getBookIdList();

	List<Book> getBookList();
	
	List<Book> getBookListByPageNo(int pageNo);
	
	List<Book> getBookByConndition(Book book) throws BookException;
	
	int  getRecordCount();
	
	int getPageSize();
}
