<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
$(function(){
	
	load();//加载数据
});
function load(){
	
	 var url="${pageContext.request.contextPath}/doMessage";
	    var args={"time":new Date()};
	    $.get(url,args,function(data){
	    	var json=eval(data);//函数可计算某个字符串，并执行其中的的 JavaScript 代码。
	    	var arr=json.shop;//通过Key friend，拿到最外面的jsonobject
	    	//alert(arr);
	    	var str="";
	    	//遍历数组
	    	$.each(arr,function(index,obj){
	    		//alert(index+","+obj.name);
	    		str+= "<tr>" + "<td>" + obj.shopid
				+ "</td>" + "<td>" + obj.shopname + "</td>" + "<td>"
				+ obj.sellid + "</td>" + "<td>" + obj.shopaddress + "</td>"
				 + "<td>" + "<input type='button' id='"+obj.shopid+"' value='留言' onclick='sendMessage("+obj.shopid+")'>" + "</td>"
				+ "</tr>";
	    	});
	    	$("#tbody").empty();
			$("#tbody").append(str);
	    },"json");//当服务器返回的json格式，一定要指定json
}
function sendMessage(shopid){
	var url="${pageContext.request.contextPath}/doSendMessage";
	var args = {"shopid":shopid,"info":$("#info").val()};
	$.get(url,args,function(result){
		var json = eval(result);
		var message = json.message;
	},"json");
}
</script>
<table border="1" class="table table-striped table-bordered">
<thead>
	<th>ID</th>
	<th>姓名</th>
	<th>卖家ID</th>
	<th>地址</th>
	<th>操作</th>
</thead>
<tbody id="tbody">
</tbody>
</table>
留言：
<input type="text" id="info"> 
<form action="${pageContext.request.contextPath}/doSendMessage">
	<input type="button" value="留言">
</form>

</body>
</html>