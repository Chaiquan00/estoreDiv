
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="search-product">
    <form action="${pageContext.request.contextPath}/ProductServlet?action=selectProductByName" method="post">
        <label for="name">搜索商品：</label>
        <input type="text" id="name" name="name">
        <input type="image" src="${pageContext.request.contextPath}/images/systemImages/Search.gif" required="required">
    </form>
</div>
