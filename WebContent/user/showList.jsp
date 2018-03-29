<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, com.bms.bean.*" %>
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
	<%
		List<User> list = (List<User>)request.getAttribute("userList");
		pageContext.setAttribute("userList", list);
	%>
	<a href="<%=basePath%>index.jsp">回到首页</a>&nbsp;&nbsp;
	<a href="<%=basePath%>admin_main.jsp">返回</a>
	<hr />
	<table border="1" cellspacing="0">
		<tr>
			<td>用户ID</td>
			<td>用户名</td>
			<td>操作</td>
		</tr>
		<c:if test="${userList != null && userList.size() > 0 }">
			<c:forEach var="user" begin="0" end="${userList.size()}" items="${userList}">
				<tr>
					<td><c:out value="${user.getUid()}" /></td>	
					<td><c:out value="${user.getUsername()}" /></td>
					<td>
						<a href="UserListController?uid=${user.getUid()}">修改</a>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>