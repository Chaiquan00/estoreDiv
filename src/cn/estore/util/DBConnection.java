package cn.estore.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://47.118.50.75:3306/estoredb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private String username = "navicate";
	private String password = "Qaz123456789";

	public Connection connection = null;

	public DBConnection() {
		try {
			Class.forName(dbDriver).newInstance();//加载驱动
			connection = DriverManager.getConnection(url, username, password);//创建连接
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库访问失败");
		}

	}

}
