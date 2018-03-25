package com.bms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.Book;
import com.bms.server.impl.BookServerImpl;

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
		
		try {
			Book book = createBook(request);
			if(bookServerImpl.addBook(book)) {
				//添加成功,进入查询所有页面
				response.sendRedirect(request.getContextPath()+"/BookListController");
			}else {
				//添加失败
				response.sendRedirect(request.getContextPath()+"/book/error.jsp");
			}
				
		} catch (ParseException e) {
			//时间转换错误
			e.printStackTrace();
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private Date stringToDate(String str) throws ParseException {
		//时间格式 --> String 转换为 Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(str);
	}
	
	private Book createBook(HttpServletRequest request) throws ParseException {
		//获取表单值
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		Date publishTime = stringToDate(request.getParameter("publishTime"));
		
		//创建图书对象
		Book book = new Book();
		book.setBname(bname);
		book.setAuthor(author);
		book.setPress(press);
		book.setPublishTime(publishTime);
		return book;
	}
	
	 /*
			Object xxxx(request,class)
	*
	*/
}
