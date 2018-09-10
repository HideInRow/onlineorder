<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String info = "";
	if(request.getParameter("info")!=null){
		info = request.getParameter("info").toString();
		out.print(info);
	}
%>
<body>
<script type="text/javascript">
$(function(){
  $("#orderinfo").html('<%=info%>');
});
</script>
<form action="${pageContext.request.contextPath }/shoppingCar">
<input type="hidden" value="shoppingCar" name="method"> 
	<textarea rows="10" cols="20" id="orderinfo" name="orderinfo"></textarea>
	<input type="submit" value="提交购物车">
</form>
</body>
</html>