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
import com.bms.server.IBookServer;
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
    private IBookServer bookServer = new BookServerImpl(); 
	
	
    public BookSearchInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		Book book = (Book) RequestUtil.getParamsInjectObj(request, Book.class);
		//存在格式格式异常
		if(request.getSession().getAttribute("error") != null) {
			response.sendRedirect("book/searchBook.jsp");
			return ;
		}
		
		try {
			List<Book> booklist = bookServer.getBookByConndition(book);
			int pageSize = bookServer.getPageSize();
			int recordNum = booklist.size();
			int pageNum = recordNum % pageSize == 0 ? recordNum / pageSize : recordNum / pageSize + 1;

			request.getSession().setAttribute("pageNo", 1);
			request.getSession().setAttribute("pageNum", pageNum);
			request.getSession().setAttribute("recordNum", recordNum);
			
			request.setAttribute("booklist", booklist);
			request.getRequestDispatcher("/book/showBookList.jsp").forward(request, response);
		} catch (BookException e) {
			request.getSession().setAttribute("error", e.getContent());
			response.sendRedirect("book/searchBook.jsp");
			return ;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
