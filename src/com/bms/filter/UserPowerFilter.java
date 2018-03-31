package com.bms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *  date : 2018年3月25日	
 * 	author: shixiaodong
 * 
 */

public class UserPowerFilter implements Filter {

	
	public void init(FilterConfig fConfig) throws ServletException {

	}
	
	//特定权限过滤
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		HttpSession session = ((HttpServletRequest)request).getSession();
		Object object = session.getAttribute("uid");
		if(object != null) {
			chain.doFilter(request, response);
			return ;
		}
		session.setAttribute("error", "请先登陆!");
		((HttpServletResponse)response).sendRedirect("user/login.jsp");
		
	}

	@Override
	public void destroy() {
		
		
	}

	
	
}
