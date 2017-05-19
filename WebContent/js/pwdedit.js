$(function(){
	$("#oldpwd").blur(checkPassword);
});
function checkPassword(){
	var oldpwd = $("#oldpwd").val();
	$.get("person/checkpassword",{oldpwd:oldpwd},function(data){
		if( data == "true"){
			alert("旧密码正确");
			
		}else{
			alert("旧密码不正确");
			$("#oldpwd").val("");
		}
	});
	
}
