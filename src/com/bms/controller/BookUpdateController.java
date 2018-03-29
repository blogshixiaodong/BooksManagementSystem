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
import com.utils.DateFormat;
import com.utils.RequestUtil;

/**
 *  date : 2018年3月25日	
 * author: jiangjiamin
 * 
 */
@WebServlet("/BookUpdateController")
public class BookUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookServerImpl bookServerImpl = new BookServerImpl(); 
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
			Book book = (Book)RequestUtil.getParamsInjectObj(request, Book.class);
			
			if(request.getSession().getAttribute("excep") != null) {
				request.setAttribute("book", book);
				response.sendRedirect(request.getContextPath()+"/book/addBook.jsp");
				return ;
			}
			
			try {
				if(bookServerImpl.updateBook(book)) {
					//response.sendRedirect("book/showBookList.jsp");
					response.sendRedirect(request.getContextPath()+"/BookListController?flag=1");
				}
				
				
			}catch (BookException e) {
				//信息错误，抛出错误信息
				if(book.getPublishTime() != null) {
					//request.setAttribute("time", DateFormat.dateToString(book.getPublishTime()));
					System.out.println(book.getPublishTime().toString());
				}
				request.getSession().setAttribute("excep", e);	
				request.setAttribute("book", book);
				request.getRequestDispatcher("/book/updateBookInfo.jsp").forward(request, response);
			}
			
			/*try {
				bookServerImpl.updateBook(book);
			} catch (BookException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("BookListController?flag=1");*/
			
			
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
