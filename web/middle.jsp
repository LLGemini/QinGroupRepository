<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 2016/7/7
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<head>
</head>
<body>
<div id="header" class="wrap">
    	<div id="logo"><img src="images/logo.gif" /></div>
    	<div class="help"><a href="#" class="shopping">购物车</a>
            <c:if test="${user==null}">
        		<a href="login.jsp">登录</a>
        		<a href="register.jsp">注册</a>
        		</c:if>
    		<a href="guestbook.jsps">留言</a></div>
    	<div class="navbar">
    		<ul class="clearfix">
    			<li class="current"><a href="#">首页</a></li>
    			<li><a href="#">图书</a></li>
    			<li><a href="#">百货</a></li>
    			<li><a href="#">品牌</a></li>
    			<li><a href="#">促销</a></li>
    		</ul>
    	</div>
    </div>
<div id="childNav">
    	<div class="wrap">
    		<ul class="clearfix">
    			<li class="first"><a href="#">音乐</a></li>
    			<li><a href="#">影视</a></li>
    			<li><a href="#">少儿</a></li>
    			<li><a href="#">动漫</a></li>
    			<li><a href="#">小说</a></li>
    			<li><a href="#">外语</a></li>
    			<li><a href="#">数码相机</a></li>
    			<li><a href="#">笔记本</a></li>
    			<li><a href="#">羽绒服</a></li>
    			<li><a href="#">秋冬靴</a></li>
    			<li><a href="#">运动鞋</a></li>
    			<li><a href="#">美容护肤</a></li>
    		<li><a href="#">家纺用品</a></li>
    		<li><a href="#">婴幼奶粉</a></li>
    		<li><a href="#">饰品</a></li>
    			<li class="last"><a href="#">Investor Relations</a></li>
    	</ul>
    	</div>
    </div>
</body>
</html>
