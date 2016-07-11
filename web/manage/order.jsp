<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<%@ include file="top.jsp" %>
</head>
<body>
<%@ include file="middle.jsp" %>
<div class="main">
		<h2>订单管理</h2>
		<div class="manage">
			<div class="search">
				<form action="./manage/index.jsp" method="get">
					订单号：<input type="text" class="text" name="orderId" />
					订货人：<input type="text" class="text" name="userName" />
					<label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>发货地址</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
				<%
					int i = 0;
				%>
				<c:forEach items="${requestScope.orders_list}" var="order">
					<tr>
						<td class="first w4 c"><%=++i%></td>
						<td class="w1 c">${order.eo_user_name}</td>
						<td>${order.eo_user_address}</td>
						<td class="w1 c">
							<c:if test="${order.eo_status == 1}">订单</c:if>
							<c:if test="${order.eo_status == 2}">审核通过</c:if>
							<c:if test="${order.eo_status == 3}">配货</c:if>
							<c:if test="${order.eo_status == 4}">送货中</c:if>
							<c:if test="${order.eo_status == 5}">收货并确认</c:if>
						</td>
						<td class="w1 c"><a href="order-modify.jsp">修改</a> <a href="javascript:Delete(1);">删除</a></td>
					</tr>
				</c:forEach>
			</table>
			<div class="pager">
				<ul class="clearfix">
					<li><a href="#">上一页</a></li>
					<li class="current">1</li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">下一页</a></li>
				</ul>
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
