<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	
	
	
	<div style="background-color:#333;">
		<div style="float:left;">
			<a href="user/register.jsp">添加用户</a><br/>
			<!-- <a href="/UserListController">删除用户</a><br/> -->
			<a href="user/search.jsp">修改用户</a><br/>
			<a href="user/search.jsp">用户查询</a><br/>
			<a href="user/UserListController">用户列表</a><br/>
		</div>
	
		<div style="float:left;margin-left:20px">
			<a href="<%=basePath %>book/addBook.jsp">添加图书</a><br/>
			<a href="<%=basePath %>/book/searchBook.jsp">删除图书</a><br/>
			<a href="<%=basePath %>/book/searchBook.jsp">修改图书</a><br/>
			<a href="<%=basePath %>/book/searchBook.jsp">查询图书</a><br/>
			<a href="<%=basePath %>/BookListController">图书列表</a><br/>
	
		</div>

	</div> 
	
	
</body>
</html>