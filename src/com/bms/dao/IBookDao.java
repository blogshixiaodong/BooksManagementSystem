package com.bms.dao;

import java.util.List;

import com.bms.bean.Book;

/*
 * date:   2018年3月23日 下午11:47:33
 * author: Shixiaodong
 */
public interface IBookDao {
	boolean addBook(Book book);

	boolean deleteBook(String id);

	boolean updateBook(String id);
	
	boolean isExistBook(String id);

	Book getBookById(String id);

	List<Book> getBookList();
}
