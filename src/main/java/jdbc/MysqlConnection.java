package jdbc;

import java.sql.*;

/**
 * @className: MysqlConnection
 * @description: TODO
 * @author: zyd
 * @date: 2020/8/3 21:15
 * @version: 1.0
 */
public class MysqlConnection {

    private static Connection connection = null;

    private MysqlConnection() {

    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String driverClassName = "com.mysql.jdbc.Driver";	//启动驱动
        String url = "jdbc:mysql://122.51.44.233:3306/test";	//设置连接路径
        String username = "root";	//数据库用户名
        String password = "123456";	//数据库连接密码
        if (connection == null) {
            Class.forName(driverClassName); //执行驱动
            connection = DriverManager.getConnection(url, username, password); //获取连接
        }
        return connection;
    }

    public static void close() {
        try {
            if(connection != null) connection.close();  //必须要关
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
