<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" +request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title>中文</title>
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
	<table border = "1">
		<thead>
			<tr>
				<th>编号</th>
				<th>书名</th>
				<th>作者</th>
				<th>出版社</th>
				<th>出版时间</th>
				<c:if test="${sessionScope.isAdmin != null }">
					<th>删除</th>
					<th>修改</th>
				</c:if>
				<c:if test="${sessionScope.isAdmin == null }">
					<th>操作</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "book" items = "${requestScope.booklist}" >
				<tr>
					<td>${book.bid}</td>
					<td>${book.bname}</td>
					<td>${book.author}</td>
					<td>${book.press}</td>
					<td>${book.publishTime}</td>
	
					<c:if test="${sessionScope.isAdmin != null }">
						<td> <a href = "${pageContext.request.contextPath}/BookDeleteController?bid=${book.bid}">删除</a></td>
						<td> <a href = "${pageContext.request.contextPath}/BookSearchUpateInfoController?bid=${book.bid}">修改</a></td>
					</c:if>
					<c:if test="${sessionScope.isAdmin == null }">
						<th><a href = "${pageContext.request.contextPath}/BookDeleteController?bid=${book.bid}">借阅</a></th>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<div id="yeshu">
		<%
			int pageNo = Integer.parseInt(request.getSession().getAttribute("pageNo").toString());
			int pageNum = Integer.parseInt(request.getSession().getAttribute("pageNum").toString());
			int recordNum = Integer.parseInt(request.getSession().getAttribute("recordNum").toString());
			out.println("<a href=BookListController?flag=1&pageNo=1>首页</a>");
			if (pageNo != 1) {
				out.println("<a href=BookListController?flag=1&pageNo=" + (pageNo - 1) + ">上一页</a>");
			}
			
	       	for (int i = 1; i <= pageNum; i++) {
	       		if(pageNo == i) {
	       			out.println("" + i + "");
	       			continue;
	       		}
	       		out.println("<a href=BookListController?flag=1&pageNo=" + i + ">[" + i + "]</a>");
	       	}
	
	       	if (pageNo != pageNum) {
	       		out.println("<a href=BookListController?flag=1e&pageNo=" + (pageNo + 1) + ">下一页</a>");
	       	}
	       	out.println("<a href=BookListController?flag=1&pageNo=" + (recordNum/4) + ">最后一页</a>&nbsp;&nbsp;总共"+(recordNum/4) + "页");
	      %>
	</div>
</body>
</html>