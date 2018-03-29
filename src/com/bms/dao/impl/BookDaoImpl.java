package com.bms.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bms.bean.Book;
import com.bms.dao.IBookDao;
import com.bms.exception.BookException;

/**
 *  date : 2018年3月25日	
 * author: jiangjiamin
 * 
 */
public class BookDaoImpl extends BaseDao implements IBookDao {

	@Override
	public boolean addBook(Book book) throws SQLException {
		String sql = "INSERT INTO BOOK(BNAME,AUTHOR,PRESS,PUBLISHTIME) VALUES(?, ?, ?, ?)";
			pstmt = getConnection().prepareStatement(sql);
			pstmt.setString(1, book.getBname());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPress());
			pstmt.setDate(4, new java.sql.Date(book.getPublishTime().getTime()) );
			return pstmt.executeUpdate() == 1;
		
		
	}

	@Override
	public boolean deleteBook(Integer id)throws SQLException {
		String sql = "DELETE FROM BOOK WHERE BID = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeUpdate() == 1;
	}

	@Override
	public boolean updateBook(Book book)throws SQLException {
		String sql = "UPDATE BOOK SET BNAME = ?,AUTHOR = ?,"
				+ "PRESS = ?,PUBLISHTIME = ? WHERE BID = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setString(1, book.getBname());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getPress());
		pstmt.setDate(4, new java.sql.Date(book.getPublishTime().getTime()));
		pstmt.setInt(5, book.getBid());
		
		return pstmt.executeUpdate() == 1;
	}

	@Override
	public boolean isExistBook(Integer id)throws SQLException {
		String sql = "SELECT COUNT(*) FROM BOOK WHERE BID = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		if(count == 1) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Book getBookById(Integer id) throws SQLException {
		String sql = "SELECT * FROM BOOK WHERE BID = ?";
		pstmt = getConnection().prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		Book book = null;
		while(rs.next()) {
			book = new Book();
			book.setBid(id);
			book.setAuthor(rs.getString("author"));
			book.setBname(rs.getString("bname"));
			book.setPress(rs.getString("press"));
			book.setPublishTime(rs.getDate("publishTime"));
		}
		return book;
	}

	@Override
	public List<Book> getBookList() throws SQLException {
		String sql = "SELECT * FROM BOOK";
		pstmt = getConnection().prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Book> booklist =new ArrayList<Book>();
		while(rs.next()) {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setBname(rs.getString("bname"));
			book.setAuthor(rs.getString("author"));
			book.setPress(rs.getString("press"));
			book.setPublishTime(rs.getDate("publishTime"));
			booklist.add(book);
		} 
		return booklist;
	}

	@Override
	public List<Integer> getBookIdList() throws SQLException {
		//获取图书ID集合
		String sql = "SELECT BID FROM BOOK";
		pstmt = getConnection().prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Integer> idlist =new ArrayList<Integer>();
		while(rs.next()) {
			idlist.add(rs.getInt("bid"));
		} 
		return idlist;

	}

	@Override
	public List<Book> getBookByConndition(String conndition) throws SQLException {
		String sql = "SELECT * FROM BOOK WHERE 1=1" + conndition;
		pstmt = getConnection().prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Book> booklist = new ArrayList<Book>();
		while(rs.next()) {
			
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setBname(rs.getString("bname"));
			book.setAuthor(rs.getString("author"));
			book.setPress(rs.getString("press"));
			book.setPublishTime(rs.getDate("publishTime"));
			booklist.add(book);
		} 
		return booklist;
		
	}

	@Override
	public List<Book> getRecordByPageNo(int currentPageNo) throws SQLException {
		String sql = "SELECT * FROM BOOK" + " limit " + (currentPageNo - 1) + "," + getPageSize();;
		pstmt = getConnection().prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<Book> booklist =new ArrayList<Book>();
		while(rs.next()) {
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setBname(rs.getString("bname"));
			book.setAuthor(rs.getString("author"));
			book.setPress(rs.getString("press"));
			book.setPublishTime(rs.getDate("publishTime"));
			booklist.add(book);
		} 
		return booklist;
	}

	@Override
	public int getRecordCount() throws SQLException {
		String sql = "SELECT COUNT(*) FROM BOOK";
		pstmt = getConnection().prepareStatement(sql);
		rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		closeQuickly();
		return count;
	}
	
	
	
	
}
