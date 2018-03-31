package com.bms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bms.dao.impl.RecordDaoImpl;
import com.bms.server.IRecordServer;
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
		
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		Integer bid = Integer.parseInt(request.getParameter("bid"));
		IRecordServer recordServer = new RecordServerImpl();
		String info = recordServer.addRecord(uid, bid);
		if("Success".equals(info)) {
			//借阅成功
			response.sendRedirect("BorrowBookListController");
		}else {
			//借阅失败
			request.getSession().setAttribute("error", info);
			response.sendRedirect("BorrowBookListController");
		}
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
