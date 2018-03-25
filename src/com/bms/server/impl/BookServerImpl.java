package com.bms.server.impl;

import java.util.List;
import com.bms.bean.Book;
import com.bms.dao.impl.BookDaoImpl;
import com.bms.server.IBookServer;

/*
 * date:   
 * author: jiamin
 */
public class BookServerImpl implements IBookServer {
	private BookDaoImpl bookDaoImpl = new BookDaoImpl();
	
	@Override
	public boolean addBook(Book book) {
		boolean result = false;
		try {
			result =  bookDaoImpl.addBook(book);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}

	@Override
	public boolean deleteBook(String id) {
		boolean result = false;
		try {
			result = bookDaoImpl.deleteBook(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateBook(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExistBook(String id) {
		boolean result = false;
		try {
			result = bookDaoImpl.isExistBook(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Book getBookById(String id) {
		Book book = null;
		try {
			book = bookDaoImpl.getBookById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> getBookList() {
		List<Book> booklist = null;
		try {
			booklist = getBookList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return booklist;
	}
	
	
	
	
}
