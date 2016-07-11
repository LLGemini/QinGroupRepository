<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="top.jsp" %>
</head>
<body>
<%@ include file="middle.jsp" %>
	<div class="main">
		<h2>商品管理</h2>
		<div class="manage">
			<div class="search">
				<form method="get">
					商品ID：<input type="text" class="text" name="productId" />
					商品名称：<input type="text" class="text" name="productName" />
					<label class="ui-blue"><input type="submit" name="submit" value="查询" /></label>
				</form>
			</div>
			<div class="spacer"></div>
			<table class="list">
				<tr>
					<th>ID</th>
					<th>商品名称</th>
					<th>操作</th>
				</tr>
				<%
					int i = 0;
				%>
				<c:forEach items="${requestScope.products_list}" var="product">
					<tr>
						<td class="first w4 c"><%=++i%></td>
						<td class="thumb">
							<img src="${product.ep_file_name}" />
							<a href="../product-view.jsp" target="_blank">${product.ep_name}</a>
						</td>
						<td class="w1 c">
							<a href="product-modify.jsp">修改</a>
							<a href="javascript:Delete(1);">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
