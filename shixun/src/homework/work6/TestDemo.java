package homework.work6;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestDemo {
    public static void main(String[] args) {

        /**
         * 著作权归https://pdai.tech所有。
         * 链接：https://pdai.tech/md/java/basic/java-basic-lan-basic.html
         *
         * 编译器会在缓冲池范围内的基本类型自动装箱过程调用 valueOf() 方法，
         * 因此多个 Integer 实例使用自动装箱来创建并且值相同，那么就会引用相同的对象。
         *
         * 基本类型对应的缓冲池如下:
         * boolean values true and false
         * all byte values
         * short values between -128 and 127
         * int values between -128 and 127
         * char in the range \u0000 to \u007F
         * 在使用这些基本类型对应的包装类型时，就可以直接使用缓冲池中的对象。
         * 如果在缓冲池之外：
         */
        Integer m = 323;
        Integer n = 323;
        System.out.println(m == n); // false
        Integer m1 = 127;
        Integer n1 = 127;
        System.out.println(m1 == n1); // true
        Integer.valueOf(127);

    }

    @Test
    public void test() throws IOException {
        File file = new File("test.txt");

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("abc");
        fileWriter.close();
    }
}
