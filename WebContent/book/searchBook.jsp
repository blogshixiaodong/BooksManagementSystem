<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%=basePath%>index.jsp">回到首页</a>&nbsp;&nbsp;
	<c:if test="${sessionScope.isAdmin == null}">
		<a href="<%=basePath%>user_main.jsp">个人中心</a>&nbsp;&nbsp;
	</c:if>
	
	<c:if test="${sessionScope.isAdmin != null}">
		<a href="<%=basePath%>admin_main.jsp">个人中心</a>&nbsp;&nbsp;
	</c:if>
	<hr/>


	${sessionScope.excep.content}
	<%session.removeAttribute("excep"); %>

<h3>条件查询图书</h3>
	<form action = "${pageContext.request.contextPath}/BookSearchInfoController" method = "POST">
		<table>
			<tr>
				<td>编号:</td>
				<td><input type = "text" name = "bid"></td>
			</tr>
			
			<tr>
				<td>图书名:</td>
				<td><input type = "text" name = "bname"></td>
			</tr>
			
			
			<tr>
				<td>作者:</td>
				<td><input type = "text" name = "author"></td>
			</tr>
			
			
			<tr>
				<td>出版社:</td>
				<td><input type = "text" name = "press"></td>
			</tr>
			
			<tr>
				<td>出版时间:</td>
				<td><input type = "text" name = "publishTime"></td>
			</tr>
			
			<tr>
				<td><input type = "submit" value = "提交"></td>
				<td><input type = "reset" value = "重置"></td>
			</tr>
			
		</table>
	
	</form>
</body>
</html>