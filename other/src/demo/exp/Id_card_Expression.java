package demo.exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Id_card_Expression {
    public static void main(String[] args) {
        test_IdCard();
    }

    public static void test_IdCard() {
        //输入
        String[] ids = {"441523200305067519", "130681198712092019", "13068119871209201x",
                "13068119871209201", "123456789012345", "12345678901234x",
                "1234567890123"};

        //正则表达式
        String regex_ = "(\\d{14}\\w)|\\d{17}\\w";

        Pattern pattern = Pattern.compile(regex_);//创建匹配规则

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i <= ids.length; i++) {
            Matcher matcher = pattern.matcher(ids[i]);
            System.out.println("身份证：");
            buffer.append(ids[i]);
            buffer.append("     匹配:");
            buffer.append(matcher.matches());
            System.out.println(buffer.toString());
            buffer.delete(0, buffer.length());
        }
        getBirth(ids);
    }

    private static void getBirth(String[] strs) {
        String regex_birth = "(\\d{6})(\\d{8})(.*)";
        String regex_year_month_day = "(\\d{4})(\\d{2})(\\d{2})";

        Pattern birth_pattern = Pattern.compile(regex_birth);
        Pattern year_month_day_pattern = Pattern.compile(regex_year_month_day);
        System.out.println("开始获取出生日期：");

        for (int i = 0; i < strs.length; i++) {
            Matcher birth_matcher = birth_pattern.matcher(strs[i]);
            if (birth_matcher.matches()) {
                Matcher year_matcher = year_month_day_pattern.matcher(birth_matcher.group(2));
                if (year_matcher.matches()) {
                    System.out.println(strs[i] + "   中的出生年月分解为：" + "年" + year_matcher.group(1) + "月"
                            + year_matcher.group(2) + "日" + year_matcher.group(3));
                }
            }
        }

    }
}
