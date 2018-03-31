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
import com.utils.RequestUtil;
import static com.utils.StringUtils.*;

@WebServlet("/user/UserUpdateController")
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		IUserServer server = new UserServerImpl();
		User user = RequestUtil.getParamsInjectObj(request, User.class);
		if(isNullOrEmpty(user.getUsername()) || isNullOrEmpty(user.getSex()) || isNull(user.getAge())) {
			request.getSession().setAttribute("error", "信息不完整!");
			request.setAttribute("user", user);
			request.getRequestDispatcher("updateInfo.jsp").forward(request, response);
			return ;
		}
		server.updateUser(user);
		if(request.getSession().getAttribute("isAdmin") == null) {
			request.getSession().setAttribute("username", user.getUsername());
			response.sendRedirect("../user_main.jsp");
		} else {
			response.sendRedirect("../admin_main.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
