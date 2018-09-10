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
		changeInfo();
	});
   
});
	function changeInfo(){
		if(confirm("确定修改么?")){
			var url = "${pageContext.request.contextPath}/doChangeInfo";
			var args = {
					"telephone":$("#telephone").val(),
					"address":$("#address").val(),
			};
			
			//document.getElementById("sure").value
			$.post(url,args,function(data){
				  var json=eval(data);
				  var res=json.result;
				  //说明服务器返回的影响函数为大于1
				  if(res){
					  //alert("影响函数大于1");
					 //单元格所对应的行要删除
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
电话<input type="text" name="telephone" id="telephone"><br>
地址<input type="text" name="address" id="address"><br>
<a href="#" id="change">修改</a>
</body>
</html>