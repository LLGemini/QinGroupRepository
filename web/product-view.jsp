<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="middle.jsp" %>
<div id="position" class="wrap">
	您现在的位置：<a href="/welcome">易买网</a> &gt; <a href="product-list.jsp">图书音像</a> &gt; 图书
</div>
<%@ include file="left.jsp" %>
	</div>
	<div id="product" class="main">
		<h1>${requestScope.product.ep_name}</h1>
		<div class="infos">
			<div class="thumb"><img src="${requestScope.product.ep_file_name}" /></div>
			<div class="buy">
				<p>商城价：<span class="price">${requestScope.product.ep_price}</span></p>
				<p>库　存：${requestScope.product.ep_stock}</p>
				<div class="button"><input type="button" name="button" value="" onclick="goBuy(1)" /><a href="/add_shoppingcar?id=${requestScope.product.ep_id}">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				<br>${requestScope.product.ep_description}<br />
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
