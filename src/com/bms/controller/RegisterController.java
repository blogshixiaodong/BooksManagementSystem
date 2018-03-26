package com.bms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		HttpSession session = request.getSession();
		session.removeAttribute("error");
		IUserServer server = new UserServerImpl();
		if(isNullOrEmpty(username) || isNullOrEmpty(password) || isNullOrEmpty(repassword)) {
			session.setAttribute("error", "注册信息不完整!");
//			request.getRequestDispatcher("registerUser.jsp").forward(request, response);
			response.sendRedirect("register.jsp");
			return ;
		}
		if(!password.equals(repassword)) {
			session.setAttribute("error", "两次密码不一致!");
//			request.getRequestDispatcher("register.jsp").forward(request, response);
			response.sendRedirect("register.jsp");
			return ;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(repassword);
		int uid = server.registerUser(user);
		session.setAttribute("uid", uid);
		session.setAttribute("username", username);
//		request.getRequestDispatcher("registerSuccess.jsp").forward(request, response);
		response.sendRedirect("registerSuccess.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
