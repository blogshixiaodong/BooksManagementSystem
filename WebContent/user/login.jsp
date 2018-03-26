<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>     
	   
	<form action="../LoginController" method="post">
		<table>
			<c:if test="${sessionScope.error != null}">
				<tr>
					<td><c:out value="错误:" /></td>
					<td><c:out value="${sessionScope.error}" /></td>
				</tr>
				
			</c:if>
			<tr>
				<td>账号:</td>
				<td><input type="text" name="username" autocomplete="off" /><br /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="text" name="password" autocomplete="off" /><br /></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="登陆" /> &nbsp;&nbsp;
					<input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>