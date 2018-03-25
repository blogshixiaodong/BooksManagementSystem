package com.bms.server;

import java.util.List;

import com.bms.bean.Book;

/*
 * date:   
 * author: jiamin
 */
public interface IBookServer {
	boolean addBook(Book book);

	boolean deleteBook(String id);

	boolean updateBook(String id);
	
	boolean isExistBook(String id);

	Book getBookById(String id);

	List<Book> getBookList();
}
