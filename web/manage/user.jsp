<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@ include file="top.jsp" %>
</head>
<body>
<%@ include file="middle.jsp" %>
<div class="main">
		<h2>用户管理</h2>
		<div class="manage">
			<table class="list">
				<tr>
					<th>ID</th>
					<th>姓名</th>
					<th>性别</th>
					<th>Email</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<%
					int i = 0;
				%>
				<c:forEach items="${requestScope.general_users_list}" var="general_user">
				<tr>
					<td class="first w4 c"><%=++i%></td>
					<td class="w1 c">${general_user.eu_user_name}</td>
					<td class="w2 c">${general_user.eu_sex}</td>
					<td class="w2 c">
						<c:if test="${general_user.eu_sex == 1}">男</c:if>
						<c:if test="${general_user.eu_sex == 2}">女</c:if>
					</td>
					<td class="w4 c">${general_user.eu_mobile}</td>
					<td class="w1 c"><a href="user-modify.jsp">修改</a> <a href="javascript:Delete(1);">删除</a></td>
				</tr>
			</c:forEach>
				<tfoot>
				<tr align="center">
					<td colspan="5">
						<jsp:include page="paging_footer.jsp"></jsp:include>
					</td>
				</tr>
				</tfoot>
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
