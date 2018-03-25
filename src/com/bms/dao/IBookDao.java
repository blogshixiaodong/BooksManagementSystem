package com.bms.dao;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.Book;

/*
 * date:   2018骞�3鏈�23鏃� 涓嬪崍11:47:33
 * author: Shixiaodong
 */
public interface IBookDao {
	boolean addBook(Book book) throws SQLException;

	boolean deleteBook(String id) throws SQLException;

	boolean updateBook(Book book) throws SQLException;
	
	boolean isExistBook(String id) throws SQLException;

	Book getBookById(String id) throws SQLException;

	List<Book> getBookList() throws SQLException;
}
