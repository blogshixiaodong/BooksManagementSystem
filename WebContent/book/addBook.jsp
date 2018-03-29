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
<title>中文</title>
</head>
<body>

	${sessionScope.excep.content}
	<%session.removeAttribute("excep"); %>
	<a href="<%=basePath%>index.jsp">回到首页</a>&nbsp;&nbsp;
	<c:if test="${sessionScope.isAdmin != null}">
			<a href="<%=basePath%>admin_main.jsp">返回</a>
	</c:if>
	<c:if test="${sessionScope.isAdmin == null}">
		<a href="<%=basePath%>user_main.jsp">返回</a>
	</c:if>
	<hr/>
	 
	<h3>添加图书信息</h3>
	
	<form action = "${pageContext.request.contextPath}/BookAddController" method = "POST">
		<table>
			<tr>
				<td>书名:</td>
				<td><input type = "text" name = "bname" value = "${requestScope.book.bname}" ></td>
			</tr>
			
			<tr>
				<td>作者:</td>
				<td><input type = "text" name = "author" value = "${requestScope.book.author}"></td>
			</tr>
			
			<tr>
				<td>出版社:</td>
				<td><input type = "text" name = "press" value = "${requestScope.book.press}"></td>
			</tr>
			
			<tr>
				<td>出版时间:</td>
				<td><input type = "text" name = "publishTime" value = "2015-01-12"></td>
			</tr>
			
			<tr>
				<td>库存:</td>
				<td><input type = "text" name = "stock" value = "${requestScope.book.stock}"></td>
			</tr>
			
			<tr>
				<td><input type = "submit" value = "提交"></td>
				<td><input type = "reset" value = "重置"></td>
			</tr>
			
		</table>
	</form>
	

</body>
</html>