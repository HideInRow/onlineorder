<%@page import="pojo.Food"%>
<%@page import="java.util.List"%>
<%@page import="pojo.Shop"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app/detail/style/js/dist/css/bootstrap.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	<%
		session.setAttribute("isFirst", true);
	%>
});
	function addFood(foodid){
		
		$("#count"+foodid).val(parseInt($("#count"+foodid).val())+1);
		var url = "${pageContext.request.contextPath}/doOrder";
		var args = {"foodid":foodid,"count":$("#count"+foodid).val()};
		$.get(url,args,function(result){
			var json = eval(result);
			var map = json.order;
			var key = json.key;
			$("#info").val("");
             for(var i in key){
            	 if($("#info").val()==""){
            		 $("#info").val($("#info").val()+"foodid"+map[key[i]]);
            	 }else{
            		 $("#info").val($("#info").val()+"  foodid"+map[key[i]]);
            	 }
            	 
             }
            
             
		},"json");
		
	}
</script>
<h1 style="margin-left:40%">SHOP</h1>
<table border="1" class="table table-striped table-bordered" style="width:88%;margin-left:6%">
	<th class="col-md-1">食品ID</th>
	<th class="col-md-2">食品描述</th>
	<th class="col-md-1">食品姓名</th>
	<th class="col-md-1">食品价格</th>
	<th class="col-md-1">图片</th>
	<th class="col-md-1">关键词</th>
	<th class="col-md-1">食品数量</th>
	<th class="col-md-2">购买数量</th>
	<th class="col-md-3">操作</th>
	<tbody>
		<c:forEach items="${food }" var="food" varStatus="status">
				<tr>
					<td>${food.foodid }</td>
					<td>${food.descrip }</td>
					<td>${food.name }</td>
					<td>${food.price }</td>
					<td><img src="${pageContext.request.contextPath}/index.images/${food.picture }"></td>
					<td>${food.keyword }</td>
					<td>${food.count }</td>
					<td><input type="text" id="count${food.foodid }" name="count" value="0"></td>
					<td><input type="button"  class="btn btn-default btn-lg btn-block" style="background-image: url('${pageContext.request.contextPath}/index.images/nMP2ywUwIDgd.png');background-repeat:no-repeat;background-position: 30px" value="添加" onclick="addFood(${food.foodid})"></td>
				</tr>
			</c:forEach>
	</tbody>
</table>
<form action="${pageContext.request.contextPath }/app/detail/ShoppingCar.jsp" style="margin-left:8%;">
	<img src="${pageContext.request.contextPath}/index.images/nMP2ywUwIDgd.png"><br>
	<!-- <textarea row="20" col="30" id="info" name="info"></textarea><br> -->
	<textarea rows="5" cols="20" id="info" name="info"></textarea><br>
	<input type="submit" class="btn btn-default btn-lg" value="提交">
</form>

</body>
</html>