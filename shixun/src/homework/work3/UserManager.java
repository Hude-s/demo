package homework.work3;

import java.util.Scanner;

/**
 * 用户管理类
 */
public class UserManager {
    public String userName;
    public String password;
    public char gender;
    private int count = 0;
    UserService userService = new UserService();


    public void printLoginInfo() {
        System.out.println("请选择要执行的操作");
        System.out.println("0、初始化操作");
        System.out.println("1、注册");
        System.out.println("2、登录");
        System.out.println("3、退出");
    }

    /**
     * 登录/注册-界面
     */
    public void loginManager() throws RegisterException {
        System.out.println("=============欢迎进入用户管理系统==========");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printLoginInfo();
            String choose = scanner.next();
            switch (choose) {
                case "0":
                    userService.initUsers_();
                    userService.addToFile();
                    manager();
                    break;
                case "1":
                    inputInfo();
                    userService.userRegister(userName, password, gender);
                    userService.addUser(userService.getUserList());
                    break;
                case "2":
                    count = input_login();
//                    count++;
                    boolean b = userService.judgeLogin(userName, password);
                    if (b && count < 3) {
                        manager();
                    } else if (!b && count < 3) {
                        input_login();
                    } else if (count > 3) {
                        exit();
                    }
                    break;
                case "3":
                    exit();
                    break;
            }
        }
    }


    /**
     * 打印操作和提示信息
     */
    public void printOperationInfo() {
        System.out.println("欢迎：" + userName + "成功进入用户管理系统");
        System.out.println("1、查看用户");

    }

    /**
     * 管理界面
     */
    public void manager() {
        printOperationInfo();
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.next();
        switch (choose) {
            case "1":
                userService.printUsers(userService.getUserList());
                break;
            case "2":
                break;
        }
    }

    /**
     * 输入注册信息
     */
    public void inputInfo() {
        System.out.println("请输入注册的信息");
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户名：");
        userName = scanner.next();
        System.out.println("密码：");
        password = scanner.next();
        System.out.println("性别：");
        String temp = scanner.next();
        gender = (char) temp.indexOf(0);
    }

    public int input_login() {
        System.out.println("请输入登录信息");
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户名：");
        userName = scanner.next();
        System.out.println("密码：");
        password = scanner.next();
        count++;
//        if (count < 3) {
//            if (!userService.judgeLogin(userName, password)) {
//                count++;
//                System.out.println("您输入密码错误" + count + "次,超过三次将退出系统");
//            }
//        }
        return count;
    }


    /**
     * 程序退出
     */
    private void exit() {
        System.out.println("程序已经退出");
        System.exit(0);
    }

}
