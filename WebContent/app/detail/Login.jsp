<%@ page import="java.util.*" contentType="text/html;charset=GB2312" %>
<HEAD></HEAD><HTML><BODY style="background-image:url(${pageContext.request.contextPath }/index.images/cloud.jpg)"></BODY></HTML>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>��¼����</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/body.css"/> 
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
</head>
<body>
<div class="container">
<% String check = "";
	if(request.getAttribute("check")!=null){
		//PrintWriter out = response.getWriter();
		out.print("<div style='color:green'>ע��ɹ�</div>");
	}
%>
	<section id="content">
		<form action="${pageContext.request.contextPath }/doLogin">
			<h1>��¼</h1>
			<div><input type="hidden" name="method" value="doLogin"/></div>
			<div>
				<input type=text name="loginName" placeholder="�û���" required="" id="username" />
			</div>
			<div>
				<input type="password" name="loginPassword" placeholder="����" required="" id="password" />
			</div>
			<div>
				<input type=submit name="g" value="��¼" class="btn btn-primary" id="js-btn-login"/>
				<a href="#">��������?</a>
			</div>
		</form>
	</section>
</div>
<br><br><br>
<div style="text-align:center;">
<h2>�������:More Templates <a href="index.jsp">����������</a></h2>
</div>
</body>
</html>