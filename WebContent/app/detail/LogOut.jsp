<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
<%String username = ""; %>
<%
username = (String)session.getAttribute("username");
%>
<script type="text/javascript">
$(function(){
	$("#logout").click(function(){
		logout();
	});
   
});
	function logout(){
		if(confirm("确定退出么?")){
			<% session.invalidate();
			%>
			
		}
	}
	
</script>
</head>
<body>
<div>
        我是退出登录页面 (っ´Ι`)っ
</div>
<a id="logout" href="Home.jsp">退出</a><br>
</body>
</html>