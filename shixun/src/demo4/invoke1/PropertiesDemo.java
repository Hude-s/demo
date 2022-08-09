package demo4.invoke1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class PropertiesDemo {


    /**
     * 作业需求
     * 1、项目中，写一个properties文件 配置数据库连接信息
     * 2、定义一个数据库查询语句的 properties文件 product.query.sql=select * from tb_product;
     * 3、定义一个查询的方法
     * *3.1读取配置文件信息
     * *3.2读取sql 语句
     * *3.3执行sql 语句 返回ResultSet
     * *3.4利用反射技术 把ResultSet结果集返回一个List<Product>
     * <p>
     * 4、扩展：
     * *4.1  3完成的基础上 可以手写一个线程池 根据数据库链接信息构建一个线程池
     * *4.2  对于数据语句的操作  都通过线程池中一个线程（Connection）
     */

    Connection con;
    Properties sql;
    String dbPath = "src//demo4//invoke1//db.properties";
    String sqlPropertiesPath = "src//demo4//invoke1//sql.properties";

    public void loadSqlProperties() throws IOException {

        ClassLoader classLoader = PropertiesDemo.class.getClassLoader();
        URL resource = classLoader.getResource("db.properties");
        URL resource1 = classLoader.getResource("demo4/invoke1/db.properties");
        System.out.println(resource1.getPath());

        String path = resource.getPath();
        System.out.println(path);
        //读取sql操作配置文件信息
        sql = new Properties();
        sql.load(new FileInputStream(sqlPropertiesPath));
    }

    public void queryAll() throws SQLException {
        String query = (String) sql.get("sql.product.query");
        //编写准备sql预编译语句
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        ArrayList<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProductId(resultSet.getInt(1));
            product.setProductName(resultSet.getString(2));
            product.setProductPrice(resultSet.getDouble(3));
            System.out.println(product);
            products.add(product);
        }
        System.out.println(Arrays.toString(products.toArray()));
    }

    /**
     * 测试方法
     * 主要用于调用写好的方法进行测试
     * 直接加载配置文件，或直接调用查询方法，可以把加加载sql 查询配置文件写在Before里面
     *
     * @throws IOException
     * @throws SQLException
     */
    @Test
    public void PropertiesTest1() throws IOException, SQLException {
//        loadSqlProperties();
        queryAll();
    }


    /**
     * 测试的前置通知方法
     * 用于获取数据库连接对象 -->con
     *
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Before
    public void getConnect() throws SQLException, IOException, ClassNotFoundException {
        //1、加载数据库配置文件信息
        Properties p = new Properties();
        p.load(new FileInputStream(dbPath));
        String driver = (String) p.get("jdbc.driver");
        String url = (String) p.get("jdbc.url");
        String username = (String) p.get("jdbc.username");
        String password = (String) p.get("jdbc.password");
        //获取数据库连接，加载数据库驱动，下载数据库驱动添加到项目依赖上
        Class.forName(driver);
        con = DriverManager.getConnection(url, username, password);
        loadSqlProperties();
    }

    /**
     * 测试的后置通知方法
     * 用于关闭数据库的连接
     */
    @After
    public void closeConnect() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void PropertiesTest() throws IOException, ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //1、加载数据库配置文件信息
        String dbPath = "src//demo4//invoke1//db.properties";
        Properties p = new Properties();
        p.load(new FileInputStream(dbPath));
        String driver = (String) p.get("jdbc.driver");
        String url = (String) p.get("jdbc.url");
        String username = (String) p.get("jdbc.username");
        String password = (String) p.get("jdbc.password");

        //获取数据库连接，加载数据库驱动，下载数据库驱动添加到项目依赖上
        Connection con;
        Class.forName(driver);
        con = DriverManager.getConnection(url, username, password);

        System.out.println(con);


        //读取sql操作配置文件信息
        String sqlPropertiesPath = "src//demo4//invoke1//sql.properties";
        Properties sql = new Properties();
        sql.load(new FileInputStream(sqlPropertiesPath));
        //从配置文件中获取相应的sql预编译语句
        String query = (String) sql.get("sql.product.query");

        //编写准备sql预编译语句
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        Class<ArrayList> arrayListClass = ArrayList.class;
        Constructor<ArrayList> constructor = arrayListClass.getConstructor();
        ArrayList arrayList = constructor.newInstance();

        ArrayList arrayList1 = ArrayList.class.getConstructor().newInstance();

        ArrayList<Product> products = new ArrayList<>();
        while (resultSet.next()) {
            Product product = new Product();
            product.setProductId(resultSet.getInt(1));
            product.setProductName(resultSet.getString(2));
            product.setProductPrice(resultSet.getDouble(3));
//            System.out.println(product);
            products.add(product);
            arrayList.add(product);
            arrayList1.add(product);
        }
//        System.out.println(Arrays.toString(products.toArray()));
//        System.out.println(Arrays.toString(arrayList.toArray()));
        System.out.println(Arrays.toString(arrayList1.toArray()));
        con.close();
    }


}
