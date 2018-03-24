package com.bms.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.bms.bean.Book;
import com.bms.dao.IBookDao;

/*
 * date:   2018年3月24日 上午12:08:11
 * author: Shixiaodong
 */
public class BookDaoImpl extends BaseDao implements IBookDao {

	@Override
	public boolean addBook(Book book) throws SQLException {
		String sql = "INSERT INTO BOOK VALUES(?, ?, ?, ?)";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, book.getField1());
		pstmt.setString(2, book.getField2());
		return pstmt.executeUpdate() == 1;
	}

	@Override
	public boolean deleteBook(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBook(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExistBook(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book getBookById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBookList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
