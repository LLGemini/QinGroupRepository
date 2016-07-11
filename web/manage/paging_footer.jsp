<%--
  Created by IntelliJ IDEA.
  User: Flower
  Date: 2016/7/9
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>paging_footer</title>
</head>
<script type="text/javascript">
  function gotoSelectedPage()
  {
    var x = document.getElementById("navigatorForm");
    //alert("Original action: " + x.action)
    x.submit();
  }
</script>
<body>
<form action="manage_general_users" method="get" id="navigatorForm">
  <a href="manage_general_users?action=index&pageNumber=1">首页</a>
  <c:if test="${pageNumber>1}">
    <a href="manage_general_users?action=index&pageNumber=${pageNumber-1}">上一页</a>
  </c:if>
  跳转到第 <select name="pageNumber" onchange="gotoSelectedPage();">
  <c:forEach begin="1" end="${totalPages}" step="1" var="pageIndex">
    <c:choose>
      <c:when test="${pageIndex eq pageNumber}">
        <option value="${pageIndex}" selected="selected">${pageIndex}</option>
      </c:when>
      <c:otherwise>
        <option value="${pageIndex}">${pageIndex}</option>
      </c:otherwise>
    </c:choose>
  </c:forEach>
</select>页
  <c:if test="${pageNumber<totalPages}">
    <a href="manage_general_users?action=index&pageNumber=${pageNumber+1}">下一页</a>
  </c:if>
  <a href="manage_general_users?action=index&pageNumber=${totalPages}">末页</a>
</form>
</body>
</html>
