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
<title>查询用户</title>
</head>
<body>
	<a href="<%=basePath%>index.jsp">回到首页</a>&nbsp;&nbsp;
	<a href="<%=basePath%>admin_main.jsp">返回</a>
	<hr/>
	<form action="UserListController" method="post" onsubmit="return checkForm()">
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
				<td><input type="text" name="uid" autocomplete="off" /><br /></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" value="查询" /> &nbsp;&nbsp;
					<input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="<%=basePath%>jQuery/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/utils.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/searchUser.js"></script>
</body>
</html>