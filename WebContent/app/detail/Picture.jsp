<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
</head>
<body>
<%String username = ""; 

%>
<%
username = (String)session.getAttribute("username");
%>
<script type="text/javascript">
$(function(){
	url = "${pageContext.request.contextPath}/doGetPicture";
	args = {};
	$.get(url,args,function(result){
		var json = eval(result);
		var picture = json.picture;
		$("#picture").attr("src","http://localhost:8080/OnlineOrder/image/"+picture.substring(picture.lastIndexOf("\\")+1));
	},"json");
});
</script>
<div>
        欢迎用户<%=username %>登录本页面 (っ´Ι`)っ<br>
        
</div><br>
     <img id="picture"><br>
       <form action="${pageContext.request.contextPath }/doSetPicture" method="post" enctype="multipart/form-data">
         上传单个文件<input type="file" name="file"><br>
         <input type="submit" value="上传">
    </form>
</body>
</html>