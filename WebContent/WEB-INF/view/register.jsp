<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="base.jsp"%>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="main">
	<form action="register" method="post">
		<div class="login">
			 邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:<input type="text" name="email" class="input">
		</div>
		<div class="login">
			 昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:<input type="text" name="name" class="input">
		</div>
		<div class="login">
			密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="psw" class="input">
		</div>
		<div class="login">
			确认密码:<input type="password" name="password" class="input">
			<div class="error">${ requestScope.error }</div>
		</div>
		<div class="login">
			<input type="submit" value="注册" class="rg">
		</div>
		<div class="login">
			<a href="login" class="lg" >登录</a>
			<div class="error">${ requestScope.error2 }</div>
		</div>
	</form>
</div>

</body>
</html>