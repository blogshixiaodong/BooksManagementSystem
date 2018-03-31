package com.bms.server.impl;

import java.sql.SQLException;
import java.util.List;
import com.bms.bean.Book;
import com.bms.dao.IBookDao;
import com.bms.dao.impl.BookDaoImpl;
import com.bms.exception.BookException;
import com.bms.exception.ErrorList;
import com.bms.server.IBookServer;
import com.sxd.util.StringUtils;
import com.utils.SqlUtil;

/**
 *  date : 2018年3月25日	
 * author: jiangjiamin
 * 
 */
public class BookServerImpl implements IBookServer {
	private IBookDao dao = new BookDaoImpl();
	
	@Override
	public boolean addBook(Book book)throws BookException {
		boolean result = false;
		try {
			checkIsNull(book);
			result =  dao.addBook(book);
		} catch (BookException e) {
			throw new BookException(e.getContent());
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteBook(Integer bid) {
		boolean result = false;
		try {
			//库存置0
			result = dao.deleteBook(bid);
		} catch (Exception e) {
			e.printStackTrace();
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
		}else if(book.getStock() == null) {
			flag = false;
		}else if(book.getPublishTime() == null) {
			throw new BookException(ErrorList.DATE_FORMAT_ERROR);
		}else if(book.getStock() < 0) {
			throw new BookException(ErrorList.NAGETIVE_NUMBER);
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
			result = dao.updateBook(book);
		}catch (Exception e) {
			//e.printStackTrace();
			throw new BookException(ErrorList.NOT_NULL);
		}
		return result;
	}

	@Override
	public boolean isExistBook(Integer id) {
		boolean result = false;
		try {
			result = dao.isExistBook(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Book getBookById(Integer id) {
		Book book = null;
		try {
			book = dao.getBookById(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	
	@Override
	public int getRecordCount() {
		try {
			return dao.getRecordCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Book> getBookListByPageNo(int pageNo) {
		List<Book> booklist = null;
		try {
			booklist = dao.getRecordByPageNo(pageNo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return booklist;
	}

	@Override
	public List<Book> getBookList() {
		List<Book> booklist = null;
		try {
			booklist = dao.getBookList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return booklist;
	}

	/*@Override*/
	/*public List<Integer> getBookIdList() {
		List<Integer> booklist = null;
		try {
			booklist = dao.getBookIdList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return booklist;
	}*/

	@Override
	public List<Book> getBookByConndition(Book book)throws BookException {
		List<Book> booklist = null;
		String conndition = SqlUtil.getSql(book);
		
		//conndition 为空串
		if("".equals(conndition)) {
			throw new BookException(ErrorList.NO_CONDITION);
		}
		
		try {
			booklist = dao.getBookByConndition(conndition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//查询无结果
		if(booklist == null || booklist.size() == 0) {
			throw new BookException(ErrorList.NO_RECORD);
		}
		return booklist;
	}

	@Override
	public int getPageSize() {
		return dao.getPageSize(); 
	}
	
	
}
