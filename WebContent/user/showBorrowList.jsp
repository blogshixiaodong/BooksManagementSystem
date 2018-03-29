<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="" method = "POST">
	<table border = "1">
		<tr>
			<th>书名</th>
			<th>作者</th>
			<th>出版社</th>
			<th>借阅日期</th>
			<th>超期</th>
			<th>归还</th>
		</tr>
		
		<c:forEach var = "record" items = "${requestScope.recordlist}" >
			<tr>
				<td>${record[0]}</td>
				<td>${record[1]}</td>
				<td>${record[2]}</td>
				<td>${record[3]}</td>
				<td>${record[4]}</td>
				<td><a href = "<%=basePath%>/ReturnBookController?bid=${record[5]}&rid=${record[6]}&uid=10000">归还</a>  </td>
			</tr>
		</c:forEach>
		
	
	</table>
</form>

</body>
</html>