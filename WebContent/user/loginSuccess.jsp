<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
</head>
<body>
	<c:if test="${sessionScope.username  != null}">
		<c:out value="欢迎：${sessionScope.username}" />
	</c:if>
	<c:if test="${sessionScope.username == null}">
		<a href="login.jsp">登陆</a>
	</c:if>
	<br />
	<!-- 主要功能 -->
	
	<a href="register.jsp">添加用户</a><br/>
	<!--<a href="/UserListController">删除用户</a><br/>-->
	<a href="search.jsp">修改用户</a><br/>
	<a href="search.jsp">用户查询</a><br/>
	<a href="UserListController">用户列表</a><br/>
	
</body>
</html>