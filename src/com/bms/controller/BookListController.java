package com.bms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.Book;
import com.bms.server.impl.BookServerImpl;

/**
 *  date : 2018年3月27日	
 * author: jiangjiamin
 * 
 */
@WebServlet("/BookListController")
public class BookListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		BookServerImpl bookServerImpl = new BookServerImpl();
		//获取图书列表记录
		List<Book> booklist = bookServerImpl.getBookList();
		request.setAttribute("booklist", booklist);
		
		request.getRequestDispatcher("/book/showBookList.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
