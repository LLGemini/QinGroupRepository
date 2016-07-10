<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/7/7 0007
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="sdkd.com.ec.model.EbUser" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>

<div id="header" class="wrap">
    <div id="logo"><img src="../images/logo.gif" /></div>
    <div class="help"><a href="../welcome">返回前台页面</a></div>
    <div class="navbar">
        <ul class="clearfix">
            <li class="current"><a href="index.jsp">首页</a></li>
            <li><a href="../manage_general_users">用户</a></li>
            <li><a href="../manage_products">商品</a></li>
            <li><a href="../manage_orders">订单</a></li>
            <li><a href="guestbook.jsp">留言</a></li>
            <li><a href="../manage_news">新闻</a></li>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class="welcome wrap">
        <%
            EbUser user = (EbUser) session.getAttribute("user");
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String curDate = dateFormat.format(date);
        %>
        管理员<%=user.getEu_user_name()%>您好，今天是<%=curDate%>，欢迎回到管理后台。
    </div>
</div>
<div id="position" class="wrap">
    您现在的位置：<a href="../welcome">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
    <div id="menu-mng" class="lefter">
        <div class="box">
            <dl>
                <dt>用户管理</dt>
                <dd><em><a href="./manage/user-add.jsp">新增</a></em><a href="../manage_general_users">用户管理</a></dd>
                <dt>商品信息</dt>
                <dd><em><a href="./manage/productClass-add.jsp">新增</a></em><a href="../manage_product_categories">分类管理</a></dd>
                <dd><em><a href="./manage/product-add.jsp">新增</a></em><a href="../manage_products">商品管理</a></dd>
                <dt>订单管理</dt>
                <dd><a href="../manage_orders">订单管理</a></dd>
                <dt>留言管理</dt>
                <dd><a href="./manage/guestbook.jsp">留言管理</a></dd>
                <dt>新闻管理</dt>
                <dd><em><a href="./manage/news-add.jsp">新增</a></em><a href="../manage_news">新闻管理</a></dd>
            </dl>
        </div>
    </div>
</html>
