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
		<form action="" method="post">

			<div class="login">
				电影名称：<input type="text" name="mname">
			</div>
			<div class="login">
				导&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;演：<input type="text" name="director">
			</div>
			<div class="login">
				主&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;演：<input type="text" name="star">
			</div>
			<div class="login">
				<input type="submit" value="保存" class="rg">
				
			</div>
			
		</form>
	</div>
</body>

</body>
</html>