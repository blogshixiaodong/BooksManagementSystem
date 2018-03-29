package com.bms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.server.impl.RecordServerImpl;

/**
 *  date : 2018年3月29日	
 * author: jiangjiamin
 * 
 */
@WebServlet("/ReturnBookController")
public class ReturnBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ReturnBookController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer bid = Integer.parseInt(request.getParameter("bid"));
		Integer uid =  (Integer) request.getSession().getAttribute("uid");
		Integer rid = Integer.parseInt(request.getParameter("rid"));
		
		RecordServerImpl recordServerImpl = new RecordServerImpl();
		if(recordServerImpl.returnBook(bid, uid, rid)) {
			//归还成功
			//request.getRequestDispatcher("BorrowBookListController").forward(request, response);
			response.sendRedirect("BorrowBookListController");
		}else {
			//归还失败
			request.getSession().setAttribute("error", "余额不足");
			request.getRequestDispatcher("BorrowBookListController").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
