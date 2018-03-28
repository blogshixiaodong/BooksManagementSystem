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
	<a href="<%=basePath%>index.jsp">回到首页</a>&nbsp;&nbsp;
	<a href="<%=basePath%>user_main.jsp">返回</a>
	<hr/>
	<table>
		<tr>
			<td>账号:</td>
			<td><input type="text" name="uid" autocomplete="off" readonly="readonly" value="${requestScope.user.uid}"/><br /></td>
		</tr>
		<tr>
			<td>用户名:</td>
			<td><input type="text" name="username" autocomplete="off" readonly="readonly" value="${requestScope.user.username}" /><br /></td>
		</tr>
		<!--
			<tr>其他字段显示</td>
				<td><input type="text" name="username" autocomplete="off" readonly="readonly" value="${requestScope.user.username}" /><br /></td>
			</tr>
		 -->
	</table>
</body>
</html>