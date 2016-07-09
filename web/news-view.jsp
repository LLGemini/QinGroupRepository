<%@ page import="java.util.List" %>
<%@ page import="sdkd.com.ec.model.EbNews" %>
<%@ page import="sdkd.com.ec.model.EbNote" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="middle.jsp" %>
<div id="position" class="wrap">
	您现在的位置：<a href="/welcome">易买网</a> &gt; 阅读新闻
</div>
<div id="main" class="wrap">
	<div class="left-side">
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
	<div id="news" class="right-main">
		<h1>${requestScope.news.en_title}</h1>
		<div class="content">
			${requestScope.news.en_content}
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
