package homework.work1;

import java.util.Random;
import java.util.Scanner;

public class CommonDivisor {
    /**
     * 计算最大公约数
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个数");
        int num2 = scanner.nextInt();
        Random random = new Random();
//        int num1 = random.nextInt(50);
//        int num2 = random.nextInt(100);

        System.out.println(num1 + "  " + num2);

//        int min = (num1>num2)?num2:num1;
        int min = Math.min(num1, num2);

        while (num1 % min != 0 || num2 % min != 0)
            min--;
        System.out.println(min);

    }
}
