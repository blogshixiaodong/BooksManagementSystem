package com.bms.controller;

import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
>>>>>>> origin/master

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.bean.User;
import com.bms.server.IUserServer;
import com.bms.server.impl.UserServerImpl;


@WebServlet("/UserListController")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUserServer server = new UserServerImpl();
		//request中有uid参数则为查询
		String uid = request.getParameter("uid");
		HttpSession session = request.getSession();
		session.removeAttribute("error");
		if(uid != null) {
			int intUid = -1;
			try {
				intUid = Integer.parseInt(uid);
			} catch(NumberFormatException e) {
				e.printStackTrace();
				session.setAttribute("error", "输入账号非法!");
				response.sendRedirect("user/search.jsp");
//				request.getRequestDispatcher("/user/search.jsp").forward(request, response);
				return;
			}
			List<User> list = new ArrayList<User>();
			User user = server.getUserById(intUid);
			if(user == null) {
				session.setAttribute("error", "用户Id不存在!");
				response.sendRedirect("user/search.jsp");
//				request.getRequestDispatcher("/user/search.jsp").forward(request, response);
				return ;
			}
			//修改用户信息的查询
			list.add(user);
			request.setAttribute("userList", list);
			request.getRequestDispatcher("/user/showInfo.jsp").forward(request, response);
			return ;
			
		} else {
			request.setAttribute("userList", server.getUserList());
		}
		
		request.getRequestDispatcher("/user/showList.jsp").forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
