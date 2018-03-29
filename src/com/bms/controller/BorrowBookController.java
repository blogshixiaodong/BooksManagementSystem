package com.bms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.dao.impl.RecordDaoImpl;
import com.bms.server.impl.RecordServerImpl;

/**
 *  date : 2018年3月29日	
 * author: jiangjiamin
 * 
 */
@WebServlet("/BorrowBookController")
public class BorrowBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BorrowBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer uid = Integer.parseInt(request.getParameter("uid"));
		Integer bid = Integer.parseInt(request.getParameter("bid"));
		
		RecordServerImpl recordServerImpl = new RecordServerImpl();
		if(recordServerImpl.addRecord(uid, bid)) {
			//借阅成功
			//若session中可以取到用户id 则改为redirect!!!!!
			request.getRequestDispatcher("BorrowBookListController?uid=10000").forward(request, response);
		}else {
			//借阅失败
		}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
