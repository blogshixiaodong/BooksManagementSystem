package com.bms.server.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import com.bms.bean.Book;
import com.bms.dao.impl.BookDaoImpl;
import com.bms.exception.BookException;
import com.bms.exception.ErrorList;
import com.bms.server.IBookServer;
import com.sxd.util.StringUtils;
import com.utils.SqlUtil;


/**
 *  date : 2018��3��25��	
 * author: jiangjiamin
 * 
 */
public class BookServerImpl implements IBookServer {
	private BookDaoImpl bookDaoImpl = new BookDaoImpl();
	
	@Override
	public boolean addBook(Book book)throws BookException {
		boolean result = false;
		
		try {
			checkIsNull(book);
			result =  bookDaoImpl.addBook(book);
			
		} catch (BookException e) {
			
			throw new BookException(ErrorList.NOT_NULL);
		}catch (Exception e) {
			
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

	
	private void checkIsNull(Book book)throws BookException {
		boolean flag = true;
		if(StringUtils.isNullOrEmpty(book.getBname())) {
			flag = false;
		}else if(StringUtils.isNullOrEmpty(book.getAuthor())) {
			flag = false;
		}else if(StringUtils.isNull(book.getPress())) {
			flag = false;
		}else if(book.getPublishTime() == null) {
			throw new BookException(ErrorList.DATE_FORMAT_ERROR);
		}
		if(!flag) {
			throw new BookException(ErrorList.NOT_NULL);
		}
	}
	
	@Override
	public boolean updateBook(Book book)throws BookException {
		boolean result = false;
		try {
			
			checkIsNull(book);
			result = bookDaoImpl.updateBook(book);
		}catch (Exception e) {
			//e.printStackTrace();
			throw new BookException(ErrorList.NOT_NULL);
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
	public int getRecordCount() {
		try {
			return bookDaoImpl.getRecordCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Book> getBookListByPageNo(int pageNo) {
		List<Book> booklist = null;
		try {
			booklist = bookDaoImpl.getRecordByPageNo(pageNo);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			bookDaoImpl.closeQuickly();
		}
		return booklist;
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
	public List<Book> getBookByConndition(Book book)throws BookException {
		List<Book> booklist = null;
		
		//ƴ��������ѯ where ֮���������
		String conndition = SqlUtil.getSql(book);
		

			try {
				booklist = bookDaoImpl.getBookByConndition(conndition);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(booklist == null || booklist.size() == 0) {
				throw new BookException(ErrorList.NO_RECORD);
			}
		
		return booklist;
	}
}
