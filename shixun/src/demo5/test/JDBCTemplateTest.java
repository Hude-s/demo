package demo5.test;

import demo5.entity.User;
import demo5.jdbctemplateutils.JDBCTemplateUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JDBCTemplateTest {

    private JdbcTemplate myTemplate;

    @Before
    public void initTemplate() {
        this.myTemplate = JDBCTemplateUtils.getTemplate();
    }


    @Test
    public void queryForMapTest() {
        String sql = "select user_id,user_name from user where user_id = ?";
        Map<String, Object> stringObjectMap = JDBCTemplateUtils.getTemplate().queryForMap(sql, 1);
        System.out.println(stringObjectMap);
    }


    //2、测试查询一个列表
    @Test
    public void queryMapTest() {
        String sql = "select user_id,user_name from user";
        //2、定义一个Template对象
        List<Map<String, Object>> listMaps = this.myTemplate.queryForList(sql);
        System.out.println(listMaps);
        listCaseToUser(listMaps);
    }


    // 自定义一个类  User 字段 id name 定义方法  把listMaps 转换为   List<Map<String, Object>> List<User>

    public void listCaseToUser(List<Map<String, Object>> list) {
        List<User> users;
        for (Map<String, Object> stringObjectMap : list) {
//            stringObjectMap.entrySet();
//            stringObjectMap.keySet();
            for (String s : stringObjectMap.keySet()) {
                System.out.println(s);
                System.out.println(stringObjectMap.get(s));
            }
        }

    }
}
