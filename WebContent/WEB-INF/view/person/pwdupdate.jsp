<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../base.jsp"%>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>
<body>

	<div class="main">
		<form action="person/pwdupdate" method="post">

			<div class="login">
				用&nbsp;&nbsp;户&nbsp;&nbsp;名:${ sessionScope.User.name }
			</div>
			<div class="login">
				旧&nbsp;&nbsp;密&nbsp;&nbsp;码: <input type="password" name="oldpwd" id="oldpwd">
			</div>
			<div class="login">
				新&nbsp;&nbsp;密&nbsp;&nbsp;码: <input type="password" name="newpwd" id="newpwd">
			</div>
			<div class="login">
				确认密码: <input type="password" name="password" id="password">
			</div>
			
			<div class="login">
				<input type="submit" value="保存" class="rg">
			</div>

		</form>
	</div>

</body>
</html>