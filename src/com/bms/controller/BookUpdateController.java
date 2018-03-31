package com.bms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.Book;
import com.bms.exception.BookException;
import com.bms.server.IBookServer;
import com.bms.server.impl.BookServerImpl;
import com.utils.RequestUtil;

/**
 *  date : 2018年3月25日	
 * author: jiangjiamin
 * 
 */
@WebServlet("/BookUpdateController")
public class BookUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IBookServer bookServer = new BookServerImpl(); 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Book book = (Book)RequestUtil.getParamsInjectObj(request, Book.class);
		//存在格式错误	
		if(request.getSession().getAttribute("error") != null) {
			request.setAttribute("book", book);
			response.sendRedirect(request.getContextPath()+"/book/addBook.jsp");
			return ;
		}
			
		try {
			if(bookServer.updateBook(book)) {
				response.sendRedirect(request.getContextPath()+"/BookListController?flag=1");
			}	
		}catch (BookException e) {
			request.getSession().setAttribute("error", e);	
			request.setAttribute("book", book);
			request.getRequestDispatcher("/book/updateBookInfo.jsp").forward(request, response);
		}	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
