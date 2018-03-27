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
import com.utils.RequestUtil;

/**
 *  date : 2018��3��26��	
 * author: jiangjiamin
 * 
 */
@WebServlet("/BookSearchInfoController")
public class BookSearchInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookServerImpl bookServerImpl = new BookServerImpl(); 
	
	
    public BookSearchInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Book book = (Book) RequestUtil.getParamsInjectObj(request, Book.class);
		List<Book> booklist = bookServerImpl.getBookByConndition(book);
		request.setAttribute("booklist", booklist);
		
		request.getRequestDispatcher("/book/showBookList.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
