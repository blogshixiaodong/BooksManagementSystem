package com.bms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.server.impl.BookServerImpl;

/**
 *  date : 2018年3月25日	
 * author: jiangjiamin
 * 
 */
@WebServlet("/BookDeleteController")
public class BookDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookServerImpl bookServerImpl = new BookServerImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Integer bid = Integer.parseInt(request.getParameter("bid"));
		if(bookServerImpl.deleteBook(bid)) {
			//删除成功
			response.sendRedirect(request.getContextPath()+"/book/admin.jsp");
		}else {
			//删除失败
			response.sendRedirect(request.getContextPath()+"/book/error.jsp");
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
