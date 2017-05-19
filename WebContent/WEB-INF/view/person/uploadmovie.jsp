<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../base.jsp"%>

<link type="text/css" rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#btnSubmit").click(function(){
		var file = $("#upfile").val();
		if(file == null || file == ""){
			alert("没有选择文件,不能上传");
			return false;
		}
		if(file.lastIndexOf(".") == -1 ){
			alert("路径不正确");
			return false;
		}
		var allMovieExt = ".mp4|.mp3|.png|.jpg|";
		var extName = file.substring(file.lastIndexOf("."));
		if(allMovieExt.indexOf(extName + "|") == -1){
			errMsg = "改文件类型不允许上传.请上传"+allMovieExt+" 类型的文件,当前文件类型为"+extName;
			alert(errMsg);
			return false;
		}
	});
});




</script>

</head>
<body>

	<div class="main">
		<form action="person/uploadmovie" method="post" enctype="multipart/form-data">

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
				时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长：<input type="text" name="time">
			</div>
			<div class="login">
				文&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件：<input type="file" name="upfile" id="upfile">
				<span style="color: red;font-size: 11pt;">${ requestScope.message }</span>
			</div>
			<div class="login">
				<input type="submit" value="上传" class="rg" id="btnSubmit">
			</div>

		</form>
	</div>
</body>
</html>