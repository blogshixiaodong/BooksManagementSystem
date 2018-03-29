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
<title>更新用户信息</title>
</head>
<body>
	<a href="<%=basePath%>index.jsp">回到首页</a>&nbsp;&nbsp;
	<c:if test="${sessionScope.isAdmin != null}">
			<a href="<%=basePath%>admin_main.jsp">返回</a>
	</c:if>
	<c:if test="${sessionScope.isAdmin == null}">
		<a href="<%=basePath%>user_main.jsp">返回</a>
	</c:if>
	<hr/>
	
	<form action="UserUpdateController" method="post">
		<table>
			<c:if test="${sessionScope.error != null}">
				<tr>
					<td><c:out value="错误:" /></td>
					<td><c:out value="${sessionScope.error}" /></td>
					<%
						request.getSession().removeAttribute("error");
					%>
				</tr>
			</c:if>
			<tr>
				<td>账号:</td>
				<td><input type="text" name="uid" autocomplete="off" readonly="readonly" value="${requestScope.user.uid}"/><br /></td>
			</tr>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" autocomplete="off" value="${requestScope.user.username}" /><br /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="sex" autocomplete="off" value="${requestScope.user.sex}" /><br /></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="age" autocomplete="off" value="${requestScope.user.age}" /><br /></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type="submit" value="修改" /> &nbsp;&nbsp;
					<input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>