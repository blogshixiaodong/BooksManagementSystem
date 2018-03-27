package com.bms.server.impl;

import java.util.List;
import com.bms.bean.Book;
import com.bms.dao.impl.BookDaoImpl;
import com.bms.server.IBookServer;
import com.utils.SqlUtil;


/**
 *  date : 2018年3月25日	
 * author: jiangjiamin
 * 
 */
public class BookServerImpl implements IBookServer {
	private BookDaoImpl bookDaoImpl = new BookDaoImpl();
	
	@Override
	public boolean addBook(Book book) {
		boolean result = false;
		if(book == null) {
			return result;
		}
		
		try {
			result =  bookDaoImpl.addBook(book);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			bookDaoImpl.closeQuickly();
		}
		return result;
		
	}

	@Override
	public boolean deleteBook(Integer uid) {
		boolean result = false;
		try {
			result = bookDaoImpl.deleteBook(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			bookDaoImpl.closeQuickly();
		}
		return result;
	}

	@Override
	public boolean updateBook(Book book) {
		boolean result = false;
		try {
			result = bookDaoImpl.updateBook(book);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			bookDaoImpl.closeQuickly();
		}
		return result;
	}

	@Override
	public boolean isExistBook(Integer id) {
		boolean result = false;
		try {
			result = bookDaoImpl.isExistBook(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			bookDaoImpl.closeQuickly();
		}
		return result;
	}

	@Override
	public Book getBookById(Integer id) {
		Book book = null;
		try {
			book = bookDaoImpl.getBookById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			bookDaoImpl.closeQuickly();
		}
		return book;
	}

	@Override
	public List<Book> getBookList() {
		List<Book> booklist = null;
		try {
			booklist = bookDaoImpl.getBookList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			bookDaoImpl.closeQuickly();
		}
		return booklist;
	}

	@Override
	public List<Integer> getBookIdList() {
		List<Integer> booklist = null;
		try {
			booklist = bookDaoImpl.getBookIdList();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			bookDaoImpl.closeQuickly();
		}
		return booklist;
		
	}

	@Override
	public List<Book> getBookByConndition(Book book) {
		List<Book> booklist = null;
		
		//拼接条件查询 where 之后条件语句
		String conndition = SqlUtil.getSql(book);
		
		
		try {
			booklist = bookDaoImpl.getBookByConndition(conndition);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return booklist;
	}
}
