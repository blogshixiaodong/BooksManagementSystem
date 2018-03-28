<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>

</head>
<body>
	<a href="<%=basePath%>index.jsp">回到首页</a>&nbsp;&nbsp;
	<c:if test="${sessionScope.isAdmin != null}">
			<a href="../admin_main.jsp">返回</a>
		</c:if>
		<c:if test="${sessionScope.isAdmin == null}">
			<a href="../user_main.jsp">返回</a>
		</c:if>
	<hr/>
	<form action="RegisterController" method="post">
		<table>
			<c:if test="${sessionScope.error != null}">
				<tr>
					<td>错误:</td>
					<td><c:out value="${sessionScope.error}" /><br /></td>
				</tr>
				<%
					request.getSession().removeAttribute("error");
				%>
			</c:if>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username" autocomplete="off" /><br /></td>
			</tr>
			<tr>
				<td>密码:</td>
				<td><input type="text" name="password" autocomplete="off" /><br /></td>
			</tr>
			<tr>
				<td>重复密码:</td>
				<td><input type="text" name="repassword" autocomplete="off" /><br /></td>
			</tr>
<!-- 
			<tr>
				<td>备用字段1:</td>
				<td><input type="text" name="field" autocomplete="off" /><br /></td>
			</tr>
			<tr>
				<td>备用字段2:</td>
				<td><input type="text" name="field2" autocomplete="off" /><br /></td>
			</tr>
-->
			<tr>
				<td></td>
				<td>
					<input type="submit" value="注册" />
					<input type="reset" value="重置" />
					<button><a href="<%=basePath%>main.jsp">首页</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>