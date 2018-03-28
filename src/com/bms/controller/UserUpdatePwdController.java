package com.bms.controller;

import static com.utils.StringUtils.isNullOrEmpty;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bms.server.IUserServer;
import com.bms.server.impl.UserServerImpl;


@WebServlet("/user/UserUpdatePwdController")
public class UserUpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getSession().getAttribute("uid").toString();
		int intUid = Integer.parseInt(uid);
		IUserServer server = new UserServerImpl();
		HttpSession session = request.getSession();
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");

		if(isNullOrEmpty(password) || isNullOrEmpty(repassword)) {
			session.setAttribute("error", "密码不能为空");
			response.sendRedirect("updatePassword.jsp");
			return ;
		}
		if(!password.equals(repassword)) {
			session.setAttribute("error", "两次密码不一致!");
			response.sendRedirect("updatePassword.jsp");
			return ;
		}
		server.updatePassword(intUid, password);
		response.sendRedirect("../user_main.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
