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
	$("#change").click(function(){
		changePwd();
	});
   
});
	function changePwd(){
		if(confirm("确定修改么?")){
			var url = "${pageContext.request.contextPath}/doChangePassword";
			var args = {"password":$("#sure").val()};
			$.post(url,args,function(data){
				  var json=eval(data);
				  var res=json.result;
				  if(res){
					 alert("修改成功");
				  }
			  },"json"); 
			 
		}
	}
	
</script>
</head>
<body>
<div>
        欢迎用户<%=username %>登录本页面 (っ´Ι`)っ<br>
</div><br>
<input type="text" name="sure" id="sure"><br>
<a href="#" id="change">修改密码</a>

</body>
</html>