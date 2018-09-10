<%@ page import="java.util.*" contentType="text/html;charset=GB2312" %>
<HEAD></HEAD><HTML><BODY style="background-image:url(${pageContext.request.contextPath }/index.images/cloud.jpg)"></BODY></HTML>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/body.css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
</head>
<body>
<div class="container">
<% String check = "";
	if(request.getAttribute("check")!=null){
		//PrintWriter out = response.getWriter();
		out.print("<div style='color:green'>注册成功</div>");
	}
%>
	<section id="content">
		<form action="${pageContext.request.contextPath }/doLogin">
			<h1>登录</h1>
			<div><input type="hidden" name="method" value="doLogin"/></div>
			<div>
				<input type=text name="loginName" placeholder="用户名" required="" id="username" />
			</div>
			<div>
				<input type="password" name="loginPassword" placeholder="密码" required="" id="password" />
			</div>
			<div>
				<input type=submit name="g" value="登录" class="btn btn-primary" id="js-btn-login"/>
				<a href="#">忘记密码?</a>
			</div>
		</form>
	</section>
</div>
<br><br><br>
<div style="text-align:center;">
<h2>更多操作:More Templates <a href="index.jsp">返回主界面</a></h2>
</div>
</body>
</html>