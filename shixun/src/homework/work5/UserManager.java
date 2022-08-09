package homework.work5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserManager {
    public static void main(String[] args) throws RegisterException {
        ArrayList<User> users = new ArrayList<>();

        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户管理系统");
        System.out.println("请选择注册或者登录");
        while (true) {
            System.out.println("1、注册");
            System.out.println("2、登录");
            System.out.println("3、退出");
            String choose = scanner.next();
//            scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("请输入注册的用户名：");
                    String userName;
                    String password;
                    userName = scanner.next();
                    if (userName.length() < 6) {
                        throw new RegisterException(userName);
                    }
                    System.out.println("请输入注册的密码：");
                    password = scanner.next();
                    User user = new User();
                    user.setUserName(userName);
                    user.setPassword(password);
                    users.add(user);
                    break;
                case "2":
                    if (count < 3) {
                        System.out.println("输入登录名：");
                        userName = scanner.next();
                        System.out.println("输入登录密码：");
                        password = scanner.next();
                        User user1 = new User();
                        user1.setUserName(userName);
                        user1.setPassword(password);
                        boolean equals1 = false;
                        boolean equals2 = false;
                        for (User user2 : users) {
                            equals1 = user1.getUserName().equals(user2.getUserName());
                            equals2 = user1.getPassword().equals(user2.getPassword());

                        }
                        if (equals1 && equals2) {
                            System.out.println("登录成功");
                        } else {
                            count++;
                            System.out.println("您的用户名或密码错误，请重新输入，错误次数超过3次，则会退出系统，当前错误次数：" + count);
                            if (count == 3) {
                                System.out.println("您输入用户名和密码错误三次，已自动退出系统");
                                System.exit(0);
                            }
                        }
                    }
                    break;
                case "3":
                    System.out.println("退出成功");
                    System.exit(0);
                    break;
                case "4":
                    System.out.println(Arrays.toString(users.toArray()));
                    break;
            }
        }

    }
}
