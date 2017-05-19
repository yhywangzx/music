<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="base.jsp"%>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>
<body>
	<div class="main">
	<form action="login" method="post">
		<div class="login">
			 邮&nbsp;&nbsp;箱:<input type="text" name="email" class="input" id="email">
		</div>
		<div class="login">
			密&nbsp;&nbsp;码:<input type="password" name="password" class="input" id="password">
		</div>
		<div class="login">
			<input type="button" value="登录" class="submit" id="loginbtn">
		</div>
		<div class="login">
			<a href="register" class="register" >免费注册</a>
		</div>


	</form>
	</div>


</body>
</html>