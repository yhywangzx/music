<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../base.jsp"%>
<script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="js/table.js" type="text/javascript"></script>
<script type="text/javascript" src="js/mycollection.js"></script>
<link type="text/css" rel="stylesheet" href="css/movie.css">

</head>
<body>

	<form action="person/mycollection" method="post">
		<div class="div">
			<table id="ListArea" border="0" class="t1 table">
				<tr>
					<th style="width: 50px;">序号</th>
					<th>电影名</th>
					<th>导演</th>
					<th>主演</th>
					<th>上传人</th>
					<th>路径</th>
					<th style="width: 150px;">时间</th>
					<th style="width: 150px;">操作</th>
				</tr>
			<c:forEach var="item" items="${ requestScope.collectList }" varStatus="st">
					<tr>
						<td>${ st.index + 1 }</td>
						<td>${ item.movieName }</td>
						<td>${ item.director }</td>
						<td>${ item.star }</td>
						<td>${ item.userName }</td>
						<td>${ item.time }</td>
						<td>${ item.path }</td>
						<td><a href="play?id=${ item.id }">播放</a>
						<a href="download?id=${ item.id }">下载</a>
						<a href="deletecollect?id=${ item.id }" class="delete">删除</a></td>
					</tr>
				</c:forEach>
				
			</table>
		</div>
		<div class="end">
		<div class="ye">${ requestScope.pageIndex }/${ requestScope.totalPage }</div>
		<div class="foot">
			<input type="hidden" name="pageIndex" id="pageIndex" value="${requestScope.pageIndex}">
			<input type="hidden" id="totalPage" value="${requestScope.totalPage}">
			<a href="#" class="page" id="first">首页</a>&nbsp;
			<a href="#" class="page" id="previou">上一页</a>&nbsp;
			<a href="#" class="page" id="next">下一页</a>&nbsp;
			<a href="#" class="page" id="last">末页</a>
		</div>
		</div>
	</form>

</body>
</html>