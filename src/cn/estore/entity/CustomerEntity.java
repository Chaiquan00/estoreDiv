package cn.estore.entity;

public class CustomerEntity {
    private int id; // 自增编号
    private String userName; // 会员名称
    private String password; // 登录密码
    private String realName; // 真实姓名
    private String mobile; // 联系电话
    private String email; // 电子邮件
    private String passwordQuestion; // 找回密码问题
    private String passwordHintAnswer; // 问题答案
    private String passwordForget;

    public String getPasswordForget() {
        return passwordForget;
    }

    public void setPasswordForget(String passwordForget) {
        this.passwordForget = passwordForget;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordQuestion() {
        return passwordQuestion;
    }

    public void setPasswordQuestion(String passwordQuestion) {
        this.passwordQuestion = passwordQuestion;
    }

    public String getPasswordHintAnswer() {
        return passwordHintAnswer;
    }

    public void setPasswordHintAnswer(String passwordHintAnswer) {
        this.passwordHintAnswer = passwordHintAnswer;
    }

}
