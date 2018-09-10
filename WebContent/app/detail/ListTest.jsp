<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>shop</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app/detail/style/js/dist/css/bootstrap.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
<meta name="keywords" content="carousel theme, free templates, image carousel, darkgray, pixelated background, templatemo, CSS, HTML" />
<meta name="description" content="Carousel Theme with darkgray background - free CSS template provided by templatemo.com" />
<link href="${pageContext.request.contextPath }/css/templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/shoplist/jquery-1-4-2.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/shoplist/jquery-ui.min.js"></script> 
<script type="text/javascript" src="${pageContext.request.contextPath }/shoplist/showhide.js"></script> 
<script type="text/JavaScript" src="${pageContext.request.contextPath }/shoplist/jquery.mousewheel.js"></script> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/ddsmoothmenu.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/shoplist/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/shoplist/ddsmoothmenu.js">
</script>
<script type="text/javascript">
ddsmoothmenu.init({
	mainmenuid: "templatemo_menu", 
	orientation: 'h', 
	classname: 'ddsmoothmenu',
	contentsource: "markup"
})
</script> 
<script type="text/JavaScript" src="${pageContext.request.contextPath }/shoplist/cloud-carousel.1.0.5.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#carousel1").CloudCarousel(		
		{			
			reflHeight: 40,
			reflGap:2,
			titleBox: $('#da-vinci-title'),
			altBox: $('#da-vinci-alt'),
			buttonLeft: $('#slider-left-but'),
			buttonRight: $('#slider-right-but'),
			yRadius:30,
			xPos: 480,
			yPos: 32,
			speed:0.15,
		}
	);
});
</script>
</head>

<body id="home">
<div id="templatemo_header_wrapper">
	<div id="site_title"><h1><a href="#">Free CSS Templates</a></h1></div>
     <div id="templatemo_menu" class="ddsmoothmenu">
        <ul>
            <li><a href="index.jsp" class="selected">Bao Le Me</a></li>
            <li><a href="register.html">Resigter</a>
                <ul>
                    <li><span class="top"></span><span class="bottom"></span></li>
                    <li><a href="#">ResigterMess</a></li>
              	</ul>
            </li>
            <li><a href="login.html">Login</a>
                <ul>
                    <li><span class="top"></span><span class="bottom"></span></li>
                    <li><a href="#">LoginMess</a></li>
                    <li><a href="upload.jsp">upload</a></li>
                    <li><a href="choiceLookType.jsp">choiceLookType</a></li>
                    <li><a href="inputModifyMess.jsp">inputModifyMess</a></li>
                    <li><a href="modifyPassword.jsp">modifyPassword</a></li>
              	</ul>
            </li>
             <li><a href="about.html">about</a></li>
            <li><a href="helpExitLogin">Exit</a></li>
        </ul>
        <br style="clear: left" />
    </div>
    <div class="cleaner"></div>
</div>
<div id="templatemo_slider">
    <div id = "carousel1" style="width:960px; height:280px;background:none;overflow:scroll; margin-top: 20px">            
        
        <c:forEach items="${listShopByAddress }" var="shop" varStatus="status">
			<a href="${pageContext.request.contextPath }/doSelectShop?method=doSelectShop&shopname=${shop.shopname }"  rel="lightbox">
			<img class="cloudcarousel" src="${pageContext.request.contextPath}/index.images/${shop.shopname}.jpg" height="180px"  alt="CSS Templates 1" title="Website Templates 1" /></a>		
		</c:forEach>
        
        
        
        
        <%-- <a href="杨铭宇.html" rel="lightbox">
        <img class="cloudcarousel" src="${pageContext.request.contextPath}/index.images/杨铭宇.jpg" height="180px" alt="CSS Templates 1" title="Website Templates 1" /></a>
        <a href="南京鸭血粉丝.html" rel="lightbox">
        <img class="cloudcarousel" src="${pageContext.request.contextPath}/index.images/南京鸭血粉丝.jpg" height="180px" alt="CSS Templates 2" title="Website Templates 2" /></a>
        <a href="#" rel="lightbox">
        <img class="cloudcarousel" src="${pageContext.request.contextPath}/index.images/尚厨上海鸡粥.jpg" height="180px" alt="CSS Templates 3" title="Website Templates 3" /></a>
        <a href="#" rel="lightbox">
        <img class="cloudcarousel" src="${pageContext.request.contextPath}/index.images/惠美饺子.jpg" height="180px" alt="CSS Templates 4" title="Website Templates 4" /></a>
        <a href="#" rel="lightbox">
        <img class="cloudcarousel" src="${pageContext.request.contextPath}/index.images/熊孩子.jpg" height="180px" alt="Flash Templates 1" title="Flash Templates 1" /></a>
        <a href="#page/2" rel="lightbox">
        <img class="cloudcarousel" src="${pageContext.request.contextPath}/index.images/老提北.jpg" height="180px" alt="Flash Templates 2" title="Flash Templates 2" /></a>
        <a href="#page/3" rel="lightbox">
        <img class="cloudcarousel" src="${pageContext.request.contextPath}/index.images/芝根芝底.jpg" height="180px" alt="Flash Templates 3" title="Flash Templates 3" /></a>
        <a href="#page/4" rel="lightbox">
        <img class="cloudcarousel" src="${pageContext.request.contextPath}/index.images/阿姨很芒.jpg" height="180px" alt="Flash Templates 4" title="Flash Templates 4" /></a> --%>
    </div>

    <center>
    <input id="slider-left-but" style="    display: block;
    width: 30px;
    height: 30px;
    border: none;
    background: url('${pageContext.request.contextPath}/index.images/templatemo_slider_left.png');
    margin-right: 10px;" type="button" value="" />
    <input id="slider-right-but" style="    display: block;
    width: 30px;
    height: 30px;
    border: none;
    background: url('${pageContext.request.contextPath}/index.images/templatemo_slider_right.png');
    margin-right: 10px;" type="button" value=""  />
    </center>
</div>
<div id="templatemo_main">
	
    <div class="col one_third fp_services">
    <h2>Welcome!</h2>
        <img src="images/templatemo_image_04.jpg" alt="Image 04 " class="image_fl" />
        <p><a href="#" target="_parent">Carousel</a> is  free css template provided by 
           <a href="#">Tian Zhi</a> for your personal or commercial websites. Quisque nec suscipit ipsum. Fusce vitae accumsan massa.</p>
    	<ul class="templatemo_list">
            <li class="flow">Integer placerat dolor vel</li>
            <li class="flow nomr">Condimentum vulputate</li>
            <li class="flow">Itristique non suscipit id</li>
            <li class="flow nomr"> Donec eget lacus vitae leo</li>
        </ul>
    </div>
    <div class="col one_third fp_services">
        <h2>Recent News</h2>
        
    </div>
    <div class="col one_third no_margin_right fp_services">
        
       
    </div>
    
    <div class="cleaner"></div>
</div>

<div id="templatemo_bottom_wrapper">
    <div id="templatemo_bottom">
    	<div class="col one_third">
        	<h4><span></span>Restaurant</h4>
            <div class="bottom_box">
                <ul class="footer_list">
                    <li><a href="#">尚厨上海鸡粥</a></li>
                    <li><a href="#">惠美饺子</a></li>
                    <li><a href="#">南京鸭血粉丝</a></li>
                    <li><a href="#">大娘水饺</a></li>
                    <li><a href="#">杨铭宇--黄焖鸡米饭</a></li>
                </ul>  
			</div>
        </div>
        <div class="col one_third">
        	<h4><span></span>Updates</h4>
            <div class="bottom_box">
                <ul class="twitter_post">
                    <li>Curabitur nec dui venenatis sem consectetur facilisis. Donec velit nisi, lacinia sed et. <a href="#">http://bit.ly/13IwZO</a></li>
                    <li>Proin dignissim, diam nec <a href="#">@TemplateMo</a> enim lorem tempus orci, ac imperdiet ante purus in justo.</li>
                </ul>
			</div>
        </div>
        <div class="col one_third no_margin_right">
        	<h4><span></span>About Us</h4>
            <div class="bottom_box">
                <p><em>Duis sem nisl, dignissim ac feugiat in, mattis sit amet est. Duis leo leo, suscipit cursus vehicula sit amet. Sed varius pellentesque massa vel rutrum.</em></p><br />              
                <div class="footer_social_button">
                    <a href="#"><img src="images/facebook.png" title="facebook" alt="facebook" /></a>
                    <a href="#"><img src="images/flickr.png" title="flickr" alt="flickr" /></a>
                    <a href="#"><img src="images/twitter.png" title="twitter" alt="twitter" /></a>
                    <a href="#"><img src="images/youtube.png" title="youtube" alt="youtube" /></a>
                    <a href="#"><img src="images/feed.png" title="rss" alt="rss" /></a>
                </div>
            </div>
        </div>       
    	<div class="cleaner"></div>
    </div>
</div>

<div id="templatemo_footer_wrapper">
    <div id="templatemo_footer">
    	<div class="map-footer-copyright">&copy;2018 WWW.Bao.Le.Me.Com <a target="_blank" href="http://www.miibeian.gov.cn/" rel="nofollow">
        	京ICP证070791号</a> 京公网安备11010502025545号</div>
</div>
</body>
</html>