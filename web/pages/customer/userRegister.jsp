
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/userRegister.css"/>

</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/userRegister.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>

<script type="text/javascript">
    //ajax判断用户名是否存在
    function judgeUserName() {
        if ($("#username") != null || $("#username") != '') {
            $.post({
                url: "${pageContext.request.contextPath}/AjaxServlet?action=checkUsername",
                data: {"username": $("#username").val()},
                success: function (data) {
                    if (data.toString() === '用户名已存在!') {
                        $('#usernameWarning').css("color", "red");
                    } else {
                        $('#usernameWarning').css("color", "green");
                    }
                    $("#usernameWarning").html(data);
                }
            })
        } else {
            $("#usernameWarning").html = "";
        }

    }
</script>
<div class="header">
    <!-- 顶部大图 -->
    <jsp:include page="/pages/common/header.jsp"/>
</div>
<div class="container">

    <img src="${pageContext.request.contextPath}/images/systemImages/fg1.jpg">
    <form action="${pageContext.request.contextPath}/CustomerServlet?action=userRegister"
          method="post" class="registerForm" name="registerForm" onsubmit="return userRegisterCheck(registerForm);">
        <div>
            <label for="username">用户名称:</label>
            <input type="text" id="username" name="username" placeholder="用户名称" onblur="judgeUserName()"/>
            <span id="usernameWarning"></span>
        </div>
        <div>
            <label for="password">用户密码:</label>
            <input type="password" id="password" name="password" placeholder="用户密码"/>
        </div>
        <div>
            <label for="rePassword">确认密码:</label>
            <input type="password" id="rePassword" name="rePassword" placeholder="确认密码" onblur="checkPassword()"/>
            <span id="passwordWarning"></span>
        </div>
        <div>
            <label for="realName">真实姓名:</label>
            <input type="text" id="realName" name="realName" placeholder="真实姓名"/>
        </div>
        <div>
            <label for="mobile">手&emsp;&emsp;机:</label>
            <input type="text" id="mobile" name="mobile" placeholder="手机号" onblur="checkMobile()"/>
            <span id="mobileWarning"></span>
        </div>
        <div>
            <label for="email">电子邮箱:</label>
            <input type="text" id="email" name="email" placeholder="电子邮箱" onblur="checkEmail()"/>
            <span id="emailWarning"></span>
        </div>
        <div>
            <label for="passwordQuestion">密码提示:</label>
            <input type="text" id="passwordQuestion" name="passwordQuestion" placeholder="密码提示"/>
        </div>
        <div>
            <label for="passwordHintAnswer">密码答案:</label>
            <input type="text" id="passwordHintAnswer" name="passwordHintAnswer" placeholder="密码答案"/>
        </div>
        <div class="register-button">
            <span><input type="image" src="${pageContext.request.contextPath}/images/systemImages/save.jpg"></span>
            <span><input type="image" src="${pageContext.request.contextPath}/images/systemImages/clear.gif"></span>
            <span><input type="image" src="${pageContext.request.contextPath}/images/systemImages/back.gif"></span>
        </div>
    </form>
</div>
<!-- 页尾 -->
<div class="footer">
    <p>软件1932</p>
</div>
</body>
</html>
