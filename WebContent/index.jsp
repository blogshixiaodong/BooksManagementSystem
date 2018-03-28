<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<c:if test="${sessionScope.username  != null}">
		<c:out value="欢迎：${sessionScope.username}" />
		&nbsp; &nbsp;
		<a href="LogoffController">注销</a>
	</c:if>
	<c:if test="${sessionScope.username == null}">
		<a href="user/login.jsp">登陆</a>
		&nbsp; &nbsp;
		<a href="user/register.jsp">注册</a>
	</c:if>
	
	
	
	
	
	
</body>
</html>