package com.bms.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bms.server.IRecordServer;
import com.bms.server.impl.RecordServerImpl;

/**
 *  date : 2018年3月31日	
 * author: jiangjiamin
 * 
 */
@WebServlet("/BorrowHistroyRecordController")
public class BorrowHistroyRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BorrowHistroyRecordController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer uid = (Integer)request.getSession().getAttribute("uid");
		IRecordServer recordServer = new RecordServerImpl();
		
		//获取历史记录，使用数组方式保存单条记录
		List<Object[]> recordlist = recordServer.getHistoryRecordByUserId(uid);
		
		request.setAttribute("recordlist", recordlist);
		request.getRequestDispatcher("user/showBorrowHistroyList.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
