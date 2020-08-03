package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @className: TestMysql
 * @description: TODO
 * @author: zyd
 * @date: 2020/8/3 21:21
 * @version: 1.0
 */
public class TestMysql {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = null;
        try {
            Connection connection = MysqlConnection.getConnection();
            String sql = "insert into user1 values (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(3, 1);
            preparedStatement.setString(2, "Tom");
            preparedStatement.execute();
        } finally {
            if(preparedStatement != null) preparedStatement.close();
        }

        try {
            Connection connection = MysqlConnection.getConnection();
            String sql = "insert into user2 values (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(3, 1);
            preparedStatement.setString(2, "Bob");
            preparedStatement.execute();
        } finally {
            if(preparedStatement != null) preparedStatement.close();
            MysqlConnection.close();
        }
    }
}
