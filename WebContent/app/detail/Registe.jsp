<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/body.css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
 <script>
 function checkName(){
	 var xhr=new XMLHttpRequest();
	 //alert("text");
		var name=document.getElementById("name").value;
		var div=document.getElementById("message");
		xhr.onreadystatechange=function(){
			if(xhr.readyState==4){
				if(xhr.status==200){
					div.innerHTML=xhr.responseText;
				}
			}			
		}
		//异步的方式
		xhr.open("GET", "${pageContext.request.contextPath}/doValidata?name=" + name, true);
		//设置头字段
		xhr.send(null);
 }
</script>
</head>
<body style="background-image:url(${pageContext.request.contextPath }/index.images/cloud.jpg)">
<div class="container">
<% String check = "";
	if(request.getAttribute("check")!=null){
		//PrintWriter out = response.getWriter();
		out.print("<div style='color:green'>注册成功</div>");
	}
%>
	<section id="content">
		<form action="${pageContext.request.contextPath }/doRegiste">
		<h1>登录</h1>
	<input type="hidden" name="method" value="doRegiste">
	<input type="text" name="username"  onblur="checkName()" placeholder="用户名:" required=""  id="name"/>
			<div id="message"></div>
	<input type="text" name="password" placeholder="密码:" required=""><br>
	<input type="text" name="address" placeholder="地址:" required=""><br>
	<input type="text" name="telephone" placeholder="手机:" required=""><br>
	<div><input type="submit" value="注册">
	<a href="Login.jsp"><h4>已有账号，点击登录</h4></a></div>
</form>
	</section>
</div>
<br><br><br>
<div style="text-align:center;">
<h2>更多操作:More Templates <a href="index.jsp">返回主界面</a></h2>
</div>
</body>
</html>