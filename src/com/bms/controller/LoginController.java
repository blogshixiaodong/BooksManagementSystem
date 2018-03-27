package com.bms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		session.removeAttribute("error");
		IUserServer server = new UserServerImpl();
		try {
			//判断账号合法性
			intUid = Integer.parseInt(uid);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			session.setAttribute("error", "输入账号非法!");
			response.sendRedirect("user/login.jsp");
			return;
		}
		if(!server.login(intUid, password)) {
			session.setAttribute("error", "账号或密码错误!");
			response.sendRedirect("user/login.jsp");
			return;
		}
		username = server.getUserById(intUid).getUsername();
		session.setAttribute("uid", username);
		session.setAttribute("username", username);
		response.sendRedirect("user/loginSuccess.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
