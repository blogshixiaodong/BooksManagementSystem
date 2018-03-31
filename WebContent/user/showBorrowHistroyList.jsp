<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>借阅历史记录</title>
</head>
<body>
	<a href="<%=basePath%>index.jsp">回到首页</a>&nbsp;&nbsp;
	<a href="<%=basePath%>user_main.jsp">个人中心</a>&nbsp;&nbsp;
	<hr />
	
	<c:if test="${requestScope.recordlist != null}">
	<table border = "1">
		<tr>
			<th>书名</th>
			<th>作者</th>
			<th>出版社</th>
			<th>借阅日期</th>
			<th>借阅天数</th>
		</tr>
		
		<c:forEach var = "record" items = "${requestScope.recordlist}" >
			<tr>
				<td>${record[0]}</td>
				<td>${record[1]}</td>
				<td>${record[2]}</td>
				<td>${record[3]}</td>
				<td>${record[4]}</td>
			</tr>
		</c:forEach>
	</table>
	</c:if>
	
	<c:if test = "${requestScope.recordlist == null}">
		<p>没有历史借阅记录</p>
	</c:if>
	
</body>
</html>