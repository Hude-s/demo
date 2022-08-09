package demo5.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JDBCTest {

    private Connection connection;

    //初始化链接对象
    @Before
    public void initConnectionTest() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://192.168.72.50/db_test1";
        String username = "myuser";
        String password = "123456";

        connection = DriverManager.getConnection(url, username, password);
    }

    //查询所有 数据测试
    @Test
    public void getAllTest() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
//            `````````````````````````````~~~~~~~~``````~~``````````~````~`
            String username = resultSet.getString(1);
            int userId = resultSet.getInt(2);
            System.out.println(username + "  " + userId);
        }
    }

    @After
    public void closeConnect() throws SQLException {
        connection.close();
    }
}
