<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="top.jsp" %>
</head>
<body>
<%@ include file="middle.jsp" %>
	<div class="main">
		<h2>分类管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>分类名称</th>
					<th>操作</th>
				</tr>
				<%
					int parentId = 0;
				%>
				<c:forEach items="${requestScope.categories_list}" var="category">
					<c:if test="${category.epc_parent_id==0}">
						<tr>
							<td class="first w4 c"><%=++parentId%></td>
							<td>${category.epc_name}</td>
							<td class="w1 c"><a href="productClass-modify.jsp">修改</a> <a href="javascript:Delete(1);">删除</a></td>
						</tr>
					</c:if>
					<%
						int childId = 0;
					%>
					<c:forEach var ="pca" items ="${requestScope.categories_list}">
						<c:if test="${pca.epc_parent_id==category.epc_id}">
							<tr>
								<td class="first w4 c"><%=++childId%></td>
								<td class="childClass">${pca.epc_name}</td>
								<td class="w1 c"><a href="productClass-modify.jsp">修改</a> <a href="javascript:Delete(1);">删除</a></td>
							</tr>
						</c:if>
					</c:forEach>
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
