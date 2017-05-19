$(function(){
	$("#loginbtn").click(login);
});
function login(){
	var email = $.trim($("#email").val());
	var password = $.trim($("#password").val());
	
	$.post("login",{email:email,password:password},function(data){

		if(data == "true"){
	
			window.location.href = "index";
		}else{
			alert("用户名或密码错误");
		}
		
		
	});
}
