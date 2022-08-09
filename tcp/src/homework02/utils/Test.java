package homework02.utils;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        File file = new File("texz.txt");
        boolean mkdirs = file.mkdirs();
        System.out.println(mkdirs);

    }
}
