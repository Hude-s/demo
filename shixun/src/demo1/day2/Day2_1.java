package demo1.day2;

import java.util.Random;
import java.util.Scanner;

public class Day2_1 {
    public static void main(String[] args) {
        Day2_1 d = new Day2_1();
//        d.method();
        d.method1();
    }

    public void method() {
        Random r = new Random();
        for (int x = 0; x < 10; x++) {
            int number = r.nextInt(10);
            System.out.println("number:" + number);
        }
        System.out.println("-------------------");
        int i = r.nextInt(100) + 1;
        System.out.println("i:" + i);
    }

    public void method1() {
        Random r = new Random();
        int number = r.nextInt(100) + 1;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你要猜测的数字（1-100）：");
            int guessNumber = sc.nextInt();
            if (guessNumber > number){
                System.out.println("你猜的数据："+guessNumber+"大了");
            }else if (guessNumber<number){
                System.out.println("你猜的数据："+guessNumber+"大了");
            }else {
                System.out.println("恭喜你，猜中了");
                break;
            }
        }
    }
}
