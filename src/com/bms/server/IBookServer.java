package com.bms.server;

import java.util.List;

import com.bms.bean.Book;
import com.bms.exception.BookException;

/**
 *  date : 2018Äê3ÔÂ25ÈÕ	
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
	
	List<Book> getBookByConndition(Book book)throws BookException;
	

}
