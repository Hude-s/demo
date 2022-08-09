package demo5.jdbctemplateutils;


import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class JDBCTemplateUtils {
    private static Properties pp = null;

    //静态代码块
    static {
        try {
            //1、获取配置文件路径
            JDBCTemplateUtils.class.getResource("/").getPath();
            //2、读取文件
            pp = new Properties();

            //加载文件到pp 中
            pp.load(new FileReader(new File("resource//druid.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //定义一个方法 获取一个数据看连接池对象
    public static DataSource getDruidDs() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(pp.getProperty("driverClassName"));
        ds.setInitialSize(Integer.parseInt(pp.getProperty("initialSize")));
        ds.setMaxActive(Integer.parseInt(pp.getProperty("maxActive")));
        ds.setMaxWait(Long.parseLong(pp.getProperty("maxWait")));
        ds.setUsername(pp.getProperty("username"));
        ds.setPassword(pp.getProperty("password"));
        ds.setUrl(pp.getProperty("url"));
        return ds;
    }

    public static JdbcTemplate getTemplate() {
        DataSource ds = getDruidDs();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        return jdbcTemplate;
    }
//    @Test
//    public void test() {
//        DataSource ds = getDruidDs();
//        System.out.println(ds);
//    }
}

