package cn.estore.dao;

import cn.estore.entity.CustomerEntity;
import cn.estore.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {
    private Connection connection = null; // 定义连接的对象
    private PreparedStatement ps = null; // 定义预准备的对象
    private DBConnection jdbc = null; // 定义数据库连接对象

    public CustomerDao() {
        jdbc = new DBConnection();
        connection = jdbc.connection; // 利用构造方法取得数据库连接
    }

    /*
     * 按用户名搜索用户信息
     * */
    public CustomerEntity selectCustomerEntity(String name) {
        CustomerEntity user = null;
        String sql = "select * from tb_customer where user_name=? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new CustomerEntity();
                user.setId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setRealName(rs.getString(4));
                user.setMobile(rs.getString(5));
                user.setEmail(rs.getString(6));
                user.setPasswordQuestion(rs.getString(7));
                user.setPasswordHintAnswer(rs.getString(8));
                user.setPasswordForget(rs.getString(9));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("数据库访问失败：按用户名查找");
        }
        return user;
    }


    //添加用户注册信息
    public boolean insertCustomer(CustomerEntity user) {
        try {
            ps = connection.prepareStatement("insert into " +
                    "tb_customer(user_name,password,real_name,mobile,email,password_question,password_hint_answer) " +
                    "values (?,?,?,?,?,?,?)");
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRealName());
            ps.setString(4, user.getMobile());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPasswordQuestion());
            ps.setString(7, user.getPasswordHintAnswer());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("数据库访问失败：用户注册");
            return false;
        }
    }

}


















