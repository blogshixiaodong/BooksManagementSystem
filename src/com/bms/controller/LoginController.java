package com.bms.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.server.IUserServer;
import com.bms.server.impl.UserServerImpl;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int intUid = -1;
		String username = "";
		String uid = request.getParameter("username");
		String password = request.getParameter("password");
		IUserServer server = new UserServerImpl();
		try {
			//输入账号合法性校验
			intUid = Integer.parseInt(uid);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("error", "输入账号非法!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(!server.login(intUid, password)) {
			request.setAttribute("error", "账号或密码错误!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		username = server.getUserById(intUid).getUsername();
		request.getSession().setAttribute("uid", username);
		request.getSession().setAttribute("username", username);
		response.sendRedirect("success.jsp");
//		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
