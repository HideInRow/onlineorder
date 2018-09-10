<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/app/detail/style/js/dist/css/bootstrap.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath }/app/detail/style/js/jquery.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="饱了么外卖专业的外卖网上送餐平台，覆盖全国优质的外卖快餐店、特色美食生鲜外卖商家。拥有目前国内领先的网上订餐平台和优秀的外卖送餐团队">
        <meta name="keywords" content="外卖，外卖快餐店，网上订餐">
        <meta name="applicable-device" content="pc">
        <link rel="dns-prefetch" href="//xs01.meituan.net">
        <link rel="dns-prefetch" href="//p0.meituan.net">
        <link rel="dns-prefetch" href="//p1.meituan.net">
        <meta name="baidu-site-verification" content="Qu9OzfSVVJ" />
        <title>美食生鲜_水果蔬菜_外卖网上订餐平台-饱了么外卖送啥都快</title>

    <link rel="shortcut icon" type="image/vnd.microsoft.icon" href="img/favicon_1.ico">
    <link rel="icon" href="img/favicon_1.ico" size="16x16 32x32">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/map-n.css" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=l1efF5xp00r6mHIeesGh5amG"></script>
    <script src="js/analytics.js" type="text/javascript" charset="utf-8" async defer></script>
	</head>
	<!-- /OnlineOrder/WebContent/index.images/cloud.jpg -->
	<body style="background-image: url('${pageContext.request.contextPath }/index.images/cloud.jpg'); background-repeat: no-repeat;">

<div class="top-wrap">
    <div class="top-banner">
        <div class="logo fl"><img src="${pageContext.request.contextPath }/index.images/uugai.com_1532424252946.png"></div>
        <div class="userbar fr">
    <span id="dis-login" class="fl" style="color: grey; background-image: url(images/templatemo_button_01.png);background-repeat:no-repeat;padding-left: 8px;">
        <a href="${pageContext.request.contextPath}/app/detail/Registe.jsp" style="color: black;font-size: 16px">注册</a>
        <span class="lg-divide fl">|</span>
        <a href="${pageContext.request.contextPath}/app/detail/Login.jsp" style="color: black;font-size: 16px">登录</a>
    </span>
        <a href="#" style="color: black;margin-left: 20px;font-size: 16px" target="_blank"><img src="${pageContext.request.contextPath }/index.images/phone.png">下载手机版</a>
        </div>
    </div>

    <div class="map" id="map">
        <div class="top">
            </div>
			
             <div class="guider" style="visibility: hidden;height: 50px;" id="guider">
            </div>
            <div class="address m-shadow" id="address">
                <div class="address-input">
                    <div class="input-container">
                        <form action="${pageContext.request.contextPath}/index">
							<input type="hidden" name="method" value="listShop">
							<input type="text" style="height:60px;line-height: 60px" name="shopAddress" placeholder="输入地址搜索周边美食"/>
							<input type="submit" value="搜索" style="
							  float:right;
							  position: absolute;
							  left: 687.5px;
							  width: 130px;
							  height: 60px;
							  background-color: #ffd161;
							  color: #333;
							  text-align: center;
							  font-size: 20px;
							  letter-spacing: 5px;
							  padding-top: 1px;
							  padding-bottom: 1px;
							">
						</form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="merchant-join">
    <div class="content">
        <h3>商家入驻</h3>
        <p>平台优势，成单量更有保障</p>
    </div>
</div>
	</body>
</html>
