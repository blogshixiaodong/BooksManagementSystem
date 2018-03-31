package com.bms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.CheckCodeUtil;

@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应内容类型
		response.setContentType("image/jpeg");
		//设置浏览器不缓存图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		//过期时限
		response.setDateHeader("Expires", 0);
		
		//将图像输出到客户端
		ServletOutputStream sos = response.getOutputStream();	
		CheckCodeUtil ccu = new CheckCodeUtil(70, 30, 4);
		ccu.drawImage();
		byte[] buffer = ccu.getImageBuffer();
		response.setContentLength(buffer.length);
		sos.write(buffer);
		sos.close();
		
		request.getSession().setAttribute("checkCode", ccu.getCheckCode());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
