<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h3>修改图书信息</h3>
	
	<form action = "${pageContext.request.contextPath}/BookUpdateController" method = "POST">
		<input type = "hidden" name = "bid" value = "${book.bid}"/>
		<table>
			<tr>
				<td>书名:</td>
				<td><input type = "text" value = "${book.bname}" name = "bname"></td>
			</tr>
			
			<tr>
				<td>作者:</td>
				<td><input type = "text" value = "${book.author}" name = "author"></td>
			</tr>
			
			
			<tr>
				<td>出版社:</td>
				<td><input type = "text" value = "${book.press}" name = "press"></td>
			</tr>
			
			<tr>
				<td>出版时间:</td>
				<td><input type = "text" value = "${book.publishTime}" name = "publishTime"></td>
			</tr>
			
			<tr>
				<td><input type = "submit" value = "提交"></td>
				<td><input type = "reset" value = "重置"></td>
			</tr>
		
		</table>
	</form>
	
</body>
</html>