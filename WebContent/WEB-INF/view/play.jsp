<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="base.jsp"%>
<link type="text/css" rel="stylesheet" href="css/play.css" />
</head>
<body>
	<div class="main">
		<div class="show">电影名称：&nbsp;&nbsp;${ requestScope.movie.mname }</div>
		<div class="show">导&nbsp;&nbsp;演：&nbsp;&nbsp;${ requestScope.movie.director }</div>
		<div class="show">主&nbsp;&nbsp;演：&nbsp;&nbsp;${ requestScope.movie.star }</div>
		<div class="play">
		<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0" id="CuPlayer" width="446" height="68" align="middle">
			<param name="allowScriptAccess" value="sameDomain" />
			<param name="movie" value="player/CuMp3PlayerV1.swf?musicfile=movie/${ movie.path }&musictitle=${ movie.mname}" />
			<param name="quality" value="high" />
			<param name="allowfullscreen" value="true" />
			<embed src="player/CuMp3PlayerV1.swf?musicfile=movie/${ movie.path }&musictitle=${ movie.mname}" width="446" height="68" quality="high" swLiveConnect=true name="CuPlayer" align="middle" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" allowfullscreen="true"/>
		</object>
		
		</div>
		<div class="show">
			<input type="button" value="关闭"
				onclick="javascript:history.back(-1);">
		</div>
	</div>

</body>
</html>