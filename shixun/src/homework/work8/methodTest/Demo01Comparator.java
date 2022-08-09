package homework.work8.methodTest;

import java.util.Arrays;
import java.util.Comparator;

public class Demo01Comparator {
    //方法的返回值是接口，可以返回匿名内部类
    //返回值是函数式接口，可以使用lambda表达式
    public static Comparator<String> getComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
    }

    public static Comparator<String> getComparator1() {
        return (String o1, String o2) -> {
            return o1.length() - o2.length();
        };
    }

    public static Comparator<String> getComparator2() {
        return (o1, o2) -> o1.length() - o2.length();
    }

    public static void main(String[] args) {
        String[] arr = {"aaaa", "bbb", "cc", "dadffsdff"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, getComparator2());
        System.out.println(Arrays.toString(arr));

    }
}
