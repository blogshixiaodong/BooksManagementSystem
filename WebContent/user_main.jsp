<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户中心</title>
</head>
<body>

	<c:if test="${sessionScope.username  != null}">
		<c:out value="欢迎：${sessionScope.username}" />&nbsp; &nbsp;
		<a href="<%=basePath%>user/LogoffController">注销</a>&nbsp; &nbsp;
	</c:if>
	
	<c:if test="${sessionScope.username == null}">
		<a href="<%=basePath%>user/login.jsp">登陆</a>&nbsp; &nbsp;
		<a href="<%=basePath%>user/register.jsp">注册</a>&nbsp; &nbsp;
	</c:if>
	<a href="<%=basePath%>index.jsp">回到首页</a>
	
	<hr/>
	<div style="background-color:#333;">
		<div style="float:left;">
			<a href="user/UserInfoController?uid=${sessionScope.uid }">基本信息</a><br/>
			<a href="user/UserListController?uid=${sessionScope.uid }">修改信息</a><br/>
			<a href="user/updatePassword.jsp?uid=${sessionScope.uid }">修改密码</a><br/>
		</div>
	
		<div style="float:left;margin-left:20px">
			<a href="<%=basePath %>/book/searchBook.jsp">查询图书</a><br/>
			<a href="<%=basePath %>/BookListController?flag=1">图书列表</a><br/>
			<a href="<%=basePath %>/BorrowBookListController">借阅查询</a><br/>
			<a href="<%=basePath %>BorrowHistroyRecordController">历史借阅</a><br/>
		</div>

	</div> 

</body>
</html>