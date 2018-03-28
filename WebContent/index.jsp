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
<title>首页</title>
<script type="text/javascript" src="<%=basePath%>js/index.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=basePath%>jQuery/jquery-3.2.1.js"></script>
<script>
	window.onload = function() {
		getBookList();
	};
	
</script>
</head>
<body>
	<c:if test="${sessionScope.username  != null}">
		<c:out value="欢迎：${sessionScope.username}" />
		&nbsp; &nbsp;
		<a href="<%=basePath%>user/LogoffController">注销</a>
		&nbsp; &nbsp;
		<c:if test="${sessionScope.isAdmin != null}">
			<a href="admin_main.jsp">管理中心</a>
		</c:if>
		<c:if test="${sessionScope.isAdmin == null}">
			<a href="user_main.jsp">个人中心</a>
		</c:if>
	</c:if>
	<c:if test="${sessionScope.username == null}">
		<a href="<%=basePath%>user/login.jsp">登陆</a>
		&nbsp; &nbsp;
		<a href="<%=basePath%>user/register.jsp">注册</a>
	</c:if>
	&nbsp; &nbsp;
	<a href="<%=basePath%>book/searchBook.jsp">图书查询</a>
	
	<hr/>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>图书ID</th>
					<th>书名</th>
					<th>作者</th>
					<th>出版社</th>
					<th>出版时间</th>
				</tr>
			</thead>
			<tbody id="bookList">
				<!-- 列表 -->
			</tbody>
		</table>	
	</div>
	
	

	<script id="fileListTrTemp" type="text/html"> 
   		<tr>
			<td>#1</td>
			<td>#2</td>
			<td>#3</td>
			<td>#4</td>
			<td>#5</td>
		</tr>
	</script>
</body>
</html>