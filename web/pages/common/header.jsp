
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/head.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/content_left.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/content_right.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">


<div class="header-img"></div>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/ProductServlet?action=selectAllProduct&pageNum=0">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/ProductServlet?action=showProductOriginal&pageNum=0">商城新品</a>
        </li>
        <li><a href="${pageContext.request.contextPath}/ProductServlet?action=showProductDiscount&pageNum=0">特价商品</a>
        </li>
        <li><a href="#">购物车</a></li>
        <li><a href="#">订单查看</a></li>
        <li><a href="#">用户修改</a></li>
        <li><a href="#">进入后台</a></li>
    </ul>
</nav>