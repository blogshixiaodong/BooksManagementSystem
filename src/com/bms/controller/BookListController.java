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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 *  date : 2018��3��25��	
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
		List<Book> booklist = bookServerImpl.getBookList();
		if(request.getParameter("flag") == null) {
			JSONArray jArray = new JSONArray();
			JSONObject jObject = new JSONObject();
			for(int i = 0; i < booklist.size(); i++) {
				jObject.put("bid", booklist.get(i).getBid());
				jObject.put("bname", booklist.get(i).getBname());
				jObject.put("author", booklist.get(i).getAuthor());
				jObject.put("press", booklist.get(i).getPress());
				jObject.put("publishTime", booklist.get(i).getPublishTime().toString());
				jArray.add(jObject);
			}
			response.getWriter().print(jArray.toString());
			return;
		}
		
		request.setAttribute("booklist", booklist);
		request.getRequestDispatcher("/book/showBookList.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
