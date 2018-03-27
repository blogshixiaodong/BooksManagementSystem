package com.bms.controller;

import java.io.IOException;
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
 *  date : 2018年3月25日	
 * author: jiangjiamin
 */
@WebServlet("/BookAddController")
public class BookAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookServerImpl bookServerImpl = new BookServerImpl();
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
				//反射获取表单book提交数据
				Book book = (Book) RequestUtil.getParamsInjectObj(request, Book.class);
				
				if(request.getSession().getAttribute("excep") != null) {
					response.sendRedirect(request.getContextPath()+"/book/addBook.jsp");
					return ;
				}
				
				try {
					if(bookServerImpl.addBook(book)) {

						response.sendRedirect(request.getContextPath()+"/BookListController");
					}
				} catch (BookException e) {
					request.getSession().setAttribute("excep", e);
					response.sendRedirect(request.getContextPath()+"/book/addBook.jsp");
				}

				
			
				
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
