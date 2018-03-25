package com.bms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bms.bean.User;
import com.bms.server.IUserServer;
import com.bms.server.impl.UserServerImpl;

import static com.utils.StringUtils.*;


@WebServlet("/user/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		IUserServer server = new UserServerImpl();
		if(isNullOrEmpty(username) || isNullOrEmpty(password) || isNullOrEmpty(repassword)) {
			request.setAttribute("error", "注册信息不完整!");
			request.getRequestDispatcher("registerUser.jsp").forward(request, response);
			return ;
		}
		if(!password.equals(repassword)) {
			request.setAttribute("error", "两次密码不一致!");
			request.getRequestDispatcher("registerUser.jsp").forward(request, response);
			return ;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(repassword);
		int uid = server.registerUser(user);
		request.setAttribute("uid", uid);
		request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
