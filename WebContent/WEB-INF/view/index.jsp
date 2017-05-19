<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="base.jsp"%>
<link type="text/css" rel="stylesheet" href="css/index.css"/>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
</head>
<body>
<div class="top"></div>
	<c:if test="${ sessionScope.User == null }">
		<div id="header">
			<div class="logo">电影天堂</div>
			<div class="navigation">
				<ul>
					<li><a href="register">注册</a></li>
					<li><a href="login">登录</a></li>
				</ul>
			</div>
		</div>
	</c:if>

	<c:if test="${ sessionScope.User != null }">
		<div id="header">
			<div class="logo">电影天堂</div>
			<div class="navigation">
				<ul>
					<li>欢迎您！${ sessionScope.User.name }</li>
					<li><a href="cancel">退出</a></li>
				</ul>
			</div>
		</div>
	</c:if>

	<div id="content">
		<div class="left_menu">
			<ul id="nav_dot">
				<li>
					<div>
						<a href="movielist" class="a" target="yxlm">所有电影</a>
					</div>
				</li>
				<li>
					<div>
						<a href="person/mymovielist" class="a" target="yxlm">我的电影</a>
					</div>
				</li>
				<li>
					<div>
						<a href="person/mycollection" class="a" target="yxlm">我的收藏</a>
					</div>
				</li>
				<li>
					<div>
						<a href="person/pwdupdate" class="a" target="yxlm">密码修改</a>
					</div>
				</li>
			</ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
				<ul>
					<li style="margin-left: 25px;">欢迎来到电影天堂：${ sessionScope.User.name }</li>
					
				</ul>
			</div>
			<div class="main">
				<iframe width="100%" height="100%" name="yxlm" frameborder="0"></iframe>
			</div>
		</div>
	</div>
	<div class="bottom"></div>
	<div id="footer">
		<p>欢迎来到电影天堂</p>
	</div>
	<script>
		navList(12);
	</script>
</body>
</html>