<%@ page import="cn.estore.entity.ProductEntity" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>搜索<%=request.getAttribute("name")%>的结果</title>
</head>
<body>
<!--顶部-->
<div class="header">
    <jsp:include page="/pages/common/header.jsp"/>
</div>

<!--中间-->
<div class="container">
    <%--    左边--%>
    <jsp:include page="/pages/common/left.jsp"/>

    <%--    右边--%>
    <div class="content">
        <!--        商品展示顶部系统图-->
        <img src="${pageContext.request.contextPath}/images/systemImages/fg_right03.jpg">
        <%
            List<ProductEntity> productList = (List<ProductEntity>) request.getAttribute("productList");
            int pageNumber = productList.size(); // 计算出有多少条记录

            int maxPage; // 计算有多少页数
            if (pageNumber % 4 == 0) {
                maxPage = pageNumber / 4;
            } else {
                maxPage = pageNumber / 4 + 1;
            }

            String strNumber = (String) request.getAttribute("pageNum");

            int number;//待显示页码，默认为第1页 ，值为0
            if (strNumber == null) {
                number = 0;
            } else {
                number = Integer.parseInt(strNumber);
            }

            int start = number * 4;//开始条数
            int over = (number + 1) * 4;//结束条数

            int count = pageNumber - over;//还剩多少条记录
            if (count <= 0) {
                over = pageNumber;
            }

            for (int i = start; i < over; i++) {
                ProductEntity product = (ProductEntity) productList.get(i);
        %>
        <!--        商品展示框-->
        <div class="product-list">
            <div class="product-img">
                <img src="${pageContext.request.contextPath}/images/productImages/<%=product.getPicture()%>"/>
            </div>
            <div class="line"></div>
            <div class="product-text">
                <div>
                    商品名称：<%=product.getName()%>
                </div>
                <div>
                    原价：<%=product.getMarketPrice()%>
                </div>
                <div>
                    现价：<%=product.getSellPrice()%>
                </div>
                <div>
                    简介：<%=product.getDescription()%>
                </div>

                <div>
                    登录后才可购买
                </div>
            </div>
        </div>
        <%
            }
        %>
        <div class="page">
            <span>共为<%=maxPage%>页</span>
            <span>共有<%=pageNumber%>条记录</span>
            <span>当前为第<%=number + 1%>页</span>

            <%if ((number + 1) == 1) {%>
            <a>上一页</a>
            <%} else {%>
            <a href="ProductServlet?action=selectProductByName&name=<%=request.getAttribute("name")%>&pageNum=<%=number - 1%>">上一页</a>
            <%}%>

            <%if (maxPage <= (number + 1)) {%>
            <a>下一页 </a>
            <%} else {%>
            <a href="ProductServlet?action=selectProductByName&name=<%=request.getAttribute("name")%>&pageNum=<%=number + 1%>">下一页</a>
            <%}%>
        </div>
    </div>
</div>

<!--底部-->
<div class="footer">
    <p>软件1932</p>
</div>
</body>
</html>
