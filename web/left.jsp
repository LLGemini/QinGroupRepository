<%--
  Created by IntelliJ IDEA.
  User: Y
  Date: 2016/7/7
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="sdkd.com.ec.model.EbNews" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<body>
<div id="main" class="wrap">
    <div class="lefter">
        <div class="box">
            <h2>商品分类</h2>
            <dl>
                <c:forEach var="ca" items="${requestScope.category_list}">
                    <c:if test="${ca.epc_parent_id==0}">
                        <dt>${ca.epc_name}</dt>
                    </c:if>
                    <c:forEach var ="pca" items ="${requestScope.category_list}">
                        <c:if test="${pca.epc_parent_id==ca.epc_id}">
                            <dd><a href="product-list.jsp">${pca.epc_name}</a> </dd>
                        </c:if>
                    </c:forEach>
                </c:forEach>
            </dl>
        </div>
</body>
</html>
