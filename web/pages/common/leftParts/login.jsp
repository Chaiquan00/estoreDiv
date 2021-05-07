<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:if test="${sessionScope.user==null}">
    <div class="login">
        <form action="${pageContext.request.contextPath}/CustomerServlet?action=userLogin" method="post">
            <div class="username-login">
                <label for="username">用户名：</label>
                <input type="text" id="username" name="username" required="required">
            </div>
            <div class="password-login">
                <label for="password">密&emsp;码：</label>
                <input type="password" id="password" name="password" required="required">
            </div>

            <div class="login-button">
                <input type="image" src="${pageContext.request.contextPath}/images/systemImages/fg-land.gif">
                <span><a href="${pageContext.request.contextPath}/pages/customer/userRegister.jsp">注册</a></span>
                <span><a href="">忘记密码</a></span>
            </div>
        </form>
    </div>
</c:if>


<c:if test="${sessionScope.user!=null}">
    <div class="login">
        <div class="showUsername">${sessionScope.user.userName}登陆成功</div>
        <div class="showRealName">用户姓名：${sessionScope.user.realName}</div>
        <a class="quit" href="javascript:quit()">安全退出</a>
    </div>
</c:if>