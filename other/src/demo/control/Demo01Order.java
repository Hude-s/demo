package demo.control;

import java.util.Scanner;

public class Demo01Order {
    public static void main(String[] args) {
        Demo01Order order = new Demo01Order();
        order.method1();
    }

    public void method1() {
        System.out.println("开始");
        System.out.println("语句1");
        System.out.println("语句2");
        System.out.println("语句3");
        System.out.println("结束");
        System.out.println("程序为顺序结构");
    }

    public void method_if() {
        System.out.println("开始");
        int a = 10;
        int b = 20;

        if (a == b) {
            System.out.println("a等于b");
        }
        int c = 10;
        if (a == c) {
            System.out.println("a等于c");
        }
        System.out.println("结束");
        System.out.println("分支");
    }

    public void method_if1() {
        System.out.println("开始");
        int a = 100;
        a = 99;
        if (a % 2 == 0) {
            System.out.println("a是偶数");
        } else {
            System.out.println("a是奇数");
        }
        System.out.println("结束");
    }

    public void method_if2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数据：");
        int a = sc.nextInt();

        System.out.println("请输入第二个数据：");
        int b = sc.nextInt();

        if (a > b) {
            System.out.println("较大的值是a：" + a);
        } else {
            System.out.println("较大的值是b：" + b);
        }

        int max;
        if (a > b) {
            max = a;
        } else {
            max = b;
        }
        System.out.println("较大的值数值是：" + max);
    }

    public void method_if3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生的考试成绩：");
        int score = sc.nextInt();
//        if (score >= 90 && score <= 100) {
//            System.out.println("你的成绩属于优秀");
//        } else if (score >= 80 && score < 90) {
//            System.out.println("你的成绩属于好");
//        } else if (score >= 70 && score < 80) {
//            System.out.println("你的成绩属于良");
//        } else if (score >= 60 && score < 70) {
//            System.out.println("你的成绩属于及格");
//        } else {
//            System.out.println("你的成绩属于不及格");
//        }
//
//
        if(score<0||score>100){
            System.out.println("你的成绩是错误的");
        }else if(score >= 90 && score <= 100) {
            System.out.println("你的成绩属于优秀");
        } else if (score >= 80 && score < 90) {
            System.out.println("你的成绩属于好");
        } else if (score >= 70 && score < 80) {
            System.out.println("你的成绩属于良");
        } else if (score >= 60 && score < 70) {
            System.out.println("你的成绩属于及格");
        } else {
            System.out.println("你的成绩属于不及格");
        }

    }


}











