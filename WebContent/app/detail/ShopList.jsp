<%@page import="pojo.Shop"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app/detail/style/js/dist/css/bootstrap.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
<!--/OnlineOrder/WebContent/css/bootstrap.min.js  -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

</head>
<body>
<%
	String bar = (String)request.getAttribute("bar");
%>
<h1 style="margin-left:40%">shopList</h1>
<table border="1" class="table table-striped table-bordered" style="width:88%;margin-left:6%">
		<thead>
			<th class="col-md-1">店铺id</th>
			<th class="col-md-4">店铺姓名</th>
			<th class="col-md-2">地址</th>
		</thead>
		<tbody id="tbody">
			<c:forEach items="${listShopByAddress }" var="shop" varStatus="status">
				<tr>
					<td><a>${shop.shopid }</a></td>
					<td><a href="${pageContext.request.contextPath }/doSelectShop?method=doSelectShop&shopname=${shop.shopname }">${shop.shopname }</a></td>
					<td>${shop.shopaddress }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table >
	<div style="margin-left:44%;">
		<%
			out.print(bar);
		%>
	</div>
	
</body>
</html>