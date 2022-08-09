package demo.exp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionTest {
    public static void main(String[] args) {
        //创建正则表达式（模具），和需要匹配的语句
        String regex = "\\w(\\d\\d)(\\w+)";
        String regex1 = "A22";
        String testStr = "A22happy";
        String testStr1 = "A22happy1";
        String testStr2 = "15365413A22happy1";

        Pattern pattern = Pattern.compile(regex);
        Pattern pattern1 = Pattern.compile(regex1);

        Matcher matcher = pattern.matcher(testStr);
        Matcher matcher1 = pattern.matcher(testStr1);
        Matcher matcher2 = pattern1.matcher(testStr2);

        if (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println("group" + i + ":" + matcher.group(i));
            }
        }
        System.out.println("------------------");
        if (matcher1.find()) {
            for (int i = 0; i <= matcher1.groupCount(); i++) {
                System.out.println("group" + i + ":" + matcher1.group(i));
            }
        }
        matcher2.find();
        System.out.println(matcher2.start());
    }
}
