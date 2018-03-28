package com.bms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.Book;
import com.bms.exception.BookException;
import com.bms.server.impl.BookServerImpl;
import com.utils.RequestUtil;


/**
 *  date : 2018年3月26日	
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
		
		Book book = (Book) RequestUtil.getParamsInjectObj(request, Book.class);
		
		//时间格式异常
		if(request.getSession().getAttribute("excep") != null) {
			response.sendRedirect("book/searchBook.jsp");
			return ;
		}
		
		try {
			List<Book> booklist = bookServerImpl.getBookByConndition(book);
			request.setAttribute("booklist", booklist);
			request.getRequestDispatcher("/book/showBookList.jsp").forward(request, response);
		} catch (BookException e) {
			request.getSession().setAttribute("excep", e);
			response.sendRedirect("book/searchBook.jsp");
			return ;
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
