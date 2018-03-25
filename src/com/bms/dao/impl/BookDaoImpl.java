package com.bms.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bms.bean.Book;
import com.bms.dao.IBookDao;

/*
 * date:   
 * author: jiamin
 */
public class BookDaoImpl extends BaseDao implements IBookDao {

	@Override
	public boolean addBook(Book book) throws SQLException {
		String sql = "INSERT INTO BOOK VALUES(?, ?, ?, ?)";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, book.getBname());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPress());
		pstmt.setDate(4, (Date) book.getPublishTime());
		return pstmt.executeUpdate() == 1;
	}

	@Override
	public boolean deleteBook(String id)throws SQLException {
		String sql = "DELETE FROM BOOK WHERE BID = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate() == 1;
	}

	@Override
	public boolean updateBook(Book book) {
		String sql = "UPDATE BOOK WHERE ";
		return false;
	}

	@Override
	public boolean isExistBook(String id)throws SQLException {
		String sql = "SELECT COUNT(*) FROM BOOK WHERE BID = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		int count = rs.getInt(1);
		if(count == 1) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Book getBookById(String id) throws SQLException {
		String sql = "SELECT * FROM BOOK WHERE BID = ?";
		pstmt = getConnection().prepareStatement(sql);
		rs = pstmt.executeQuery();
		Book book = null;
		while(rs.next()) {
			book = new Book();
			book.setAuthor(rs.getString("author"));
			book.setBname(rs.getString("name"));
			book.setPress(rs.getString("press"));
			book.setPublishTime(rs.getDate("publishTime"));
		}
		return book;
	}

	@Override
	public List<Book> getBookList() throws SQLException {
		String sql = "SELECT * FROM BOOK";
		pstmt.getConnection().prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Book> booklist =new ArrayList<Book>();
		while(rs.next()) {
			Book book = new Book();
			book.setBname(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setPress(rs.getString("press"));
			book.setPublishTime(rs.getDate("publishTime"));
			booklist.add(book);
		} 
		return booklist;
	}
	
}
