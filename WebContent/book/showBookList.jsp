<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>中文</title>
</head>
<body>
<br><br><br>

	<table align = "center" border = "1">
		<tr>
			<th>编号</th>
			<th>书名</th>
			<th>作者</th>
			<th>出版社</th>
			<th>出版时间</th>
			<th>删除</th>
			<th>修改</th>
		</tr>
		
		<c:forEach var = "book" items = "${requestScope.booklist}" >
			<tr>
				<td>${book.bid}</td>
				<td>${book.bname}</td>
				<td>${book.author}</td>
				<td>${book.press}</td>
				<td>${book.publishTime}</td>
				<td> <a href = "${pageContext.request.contextPath}/BookDeleteController?bid=${book.bid}">删除</a></td>
				<td> <a href = "${pageContext.request.contextPath}/BookSearchUpateInfoController?bid=${book.bid}">修改</a></td>
			</tr>
		</c:forEach>
		
		

	</table>

</body>
</html>