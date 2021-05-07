function getValueById(elementId) {
    return document.getElementById(elementId).value;
}

function getElementById(elementId) {
    return document.getElementById(elementId);
}

//注册表单判断
function userRegisterCheck(form) {
    const email = getValueById("email");
    const emailReg = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;

    const mobile = getValueById("mobile");
    const phoneReg = /^[1][3,4,5,7,8,9][0-9]{9}$/;

    const username = getValueById("username")

    for (let i = 0; i < form.length; i++) {
        if (form.elements[i].value === "") {
            alert(form.elements[i].placeholder + "不能为空");
            form.elements[i].focus();
            return false;
        }
    }

    if (getValueById("password") !== getValueById("rePassword")) {
        alert("密码两次输入不一致！")
        return false;
    }
    if (mobile !== "" || mobile != null) {
        if (!phoneReg.test(mobile)) {
            alert('手机号格式不正确，请检查您的手机号!')
            return false;
        }
    }
    if (email !== "" || email != null) {
        if (!emailReg.test(email)) {
            alert("邮箱格式不正确，请检查您的邮箱！")
            return false;
        }
    }
}


// 判断密码
function checkPassword() {
    document.getElementById("passwordWarning").innerHTML = null;
    if (getValueById("password") !== getValueById("rePassword")) {
        document.getElementById("passwordWarning").innerHTML = "两次密码的输入不一致!";
        return false;
    }
}

/*验证邮箱*/
function checkEmail() {
    const email = getValueById("email");
    const emailWarning = getElementById("emailWarning");
    const reg = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
    emailWarning.innerHTML = "";
    if (reg.test(email) === false) {
        emailWarning.innerHTML = "邮箱格式不正确";
        return false;
    }

}

/*验证手机号码*/
function checkMobile() {
    const mobile = getValueById("mobile");
    const mobileWarning = getElementById("mobileWarning");
    const phoneReg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
    mobileWarning.innerHTML = "";
    if (phoneReg.test(mobile) === false) {
        mobileWarning.innerHTML = "请输入正确手机号";
        return false;
    }

}
