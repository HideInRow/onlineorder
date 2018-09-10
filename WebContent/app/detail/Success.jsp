<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
  $("#orderinfo").val('<%=session.getAttribute("orderinfo")%>\n\r');
  $("#allPrice").val("￥："+'<%=session.getAttribute("money")%>');
});
</script>
结算<br>
<textarea rows="10" cols="20" id="orderinfo" name="orderinfo"></textarea><br>
<input type="text" id="allPrice" style="color:red;font-size:20px;width:130px"><br>
<a href="${pageContext.request.contextPath }/app/index.jsp">返回首页</a>
</body>
</html>