<%@ page import="java.util.List" %>
<%@ page import="sdkd.com.ec.model.EbNews" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="middle.jsp" %>
<%@ include file="left.jsp" %>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<c:forEach items = "${requestScope.recent_visited_product_list}" var="product">
				<dl>
					<dt><img src="${product.ep_file_name}" /></dt>
					<dd><a href="/product_view?p_id=${product.ep_id}">${product.ep_name}</a></dd>
				</dl>
				</c:forEach>
			</dl>
		</div>
	</div>
	<div class="main">
		<div class="price-off">
			<h2>今日特价</h2>
			<ul class="product clearfix">
				<c:forEach items = "${requestScope.bargin_product_list}" var="product">
				<li>
					<dl>
						<dt><a href="/product_view?p_id=${product.ep_id}" target="_blank"><img src="${product.ep_file_name}" /></a></dt>
						<dd class="title"><a href="/product_view?p_id=${product.ep_id}" target="_blank">${product.ep_name}</a></dd>
						<dd class="price">${product.ep_price}</dd>
					</dl>
				</li>
				</c:forEach>
			</ul>
		</div>
		<div class="side">
			<div class="spacer"></div>
			<div class="news-list">
				<h4>最新公告</h4>
				<ul>
					<c:forEach items = "${requestScope.recent_note_list}" var="note">
						<li><a href="/note_view?note_id=${note.en_id}" target="_blank">${note.en_title}</a></li>
					</c:forEach>
				</ul>
			</div>
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
					<c:forEach items = "${requestScope.recent_news_list}" var="news">
						<li><a href="/news_view?news_id=${news.en_id}" target="_blank">${news.en_title}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				<c:forEach items = "${requestScope.hot_product_list}" var="product">
				<li>
					<dl>
						<dt><a href="/product_view?p_id=${product.ep_id}" target="_blank"><img src="${product.ep_file_name}" /></a></dt>
						<dd class="title"><a href="/product_view?p_id=${product.ep_id}" target="_blank">${product.ep_name}</a></dd>
						<dd class="price">￥${product.ep_price}</dd>
					</dl>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
