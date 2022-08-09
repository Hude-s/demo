package demo1.day06.goods_demo.utils;


import demo1.day06.goods_demo.entity.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserOperation {

    private ArrayList<User> uerr;   // 定义一个用户集合类对象

    private final String usersFilePath = "shixun\\src\\demo1\\day06\\goods_demo\\goodsdatas\\register.txt";


    public UserOperation(ArrayList<User> uerr) throws Exception {
        this.uerr = uerr;
    }

    //注册模块
    public ArrayList<User> register() throws Exception {
//        读入用户表数据
        FileReader file1 = new FileReader(usersFilePath);
        BufferedReader bufferedreader = new BufferedReader(file1);
        String line;
        while ((line = bufferedreader.readLine()) != null) {
            String[] split = line.split(",");//把每一行数据按“，”分割成字符串数组
            String account = split[0];
            String password = split[1];
            User tmp = new User(account, password);
            uerr.add(tmp);
        }
        bufferedreader.close();
        file1.close();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("===欢迎使用韶关学院超市购物系统===");
            System.out.println("请先注册或者登录");
            System.out.println("1.注册");
            System.out.println("2.登录");
            System.out.println("=======请输入操作功能编号:=======");
            int xz = sc.nextInt();
            sc.nextLine();
            switch (xz) {
                case 1:
                    //        更新用户表
                    FileWriter file2 = new FileWriter(usersFilePath);
                    BufferedWriter bufferedWriter = new BufferedWriter(file2);

                    for (int i = 0; i < uerr.size(); i++) {//将原有的数据放进输出缓冲区
                        String account = uerr.get(i).getAccount();
                        String password = uerr.get(i).getPassword();
                        bufferedWriter.write(account + "," + password + "\n");
                    }
                    //添加新用户
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请输入注册账号");
                    bufferedWriter.write(scanner.nextLine() + ",");
                    System.out.println("请输入注册密码");
                    bufferedWriter.write(scanner.nextLine() + "\n");
                    System.out.println("注册成功");
                    bufferedWriter.close();//输出新的用户表数据并释放缓冲区
                    return uerr;

                case 2:
                    //    登录模块
                    while (true) {
                        System.out.println("输入登录账号");
                        String account = sc.nextLine();
                        for (int i = 0; i < uerr.size(); i++) {
                            if (account.equals(uerr.get(i).getAccount())) {
                                System.out.println("请输入登录密码");
                                String password = sc.nextLine();
                                if (password.equals(uerr.get(i).getPassword())) {
                                    System.out.println("登录成功");
                                    return uerr;
                                }
                                System.out.printf("密码错误,");
                            }
                        }
                        System.out.printf("请重新");
                    }
            }
            System.out.println("您的输入有误，请重新输入");
        }
    }
}