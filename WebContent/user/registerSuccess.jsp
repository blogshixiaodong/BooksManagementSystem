<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%  
	String path = request.getContextPath();  
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>
<body>
	你好：${sessionScope.username}<br/>
	注册成功：你的账号为 ${sessionScope.uid}<br/>
	
	<div>
		<span class="showbox"></span>s 后自动跳转回首页...
	</div>
	跳转失败点击<a href="../user_main.jsp">回到首页</a>
	<script type="text/javascript" src="<%=basePath%>jQuery/jquery-3.2.1.js"></script>
	<script type="text/javascript">
		$(function() {
			show();
		});
		var timeout = 5;
		function show() {
		    var showbox = $(".showbox");
		     showbox.html(timeout);
		     timeout--;
		     if (timeout == 0) {
		        window.location.href = "../index.jsp";
		    }
		    else {
		        setTimeout("show()", 1000);
		    }
		}
	</script>
</body>
</html>