package homework.work3;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 用户管理类
 */
public class UserManager1 {
    public String userName;
    public String password;
    public char gender;

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
                    try {
                        InitUsers();
                        manager();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "1":
                    register();
                    inputInfo();
                    userRegister();
                    break;
                case "2":
                    login();
                    inputInfo();

                    break;
                case "3":
                    System.exit(0);
                    break;
            }
        }
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
                printUsers(showUserList());
                break;
            case "2":

                break;
        }
    }

    /**
     * 将对象从文件中反序列化出来
     */
    public ArrayList<User> showUserList() {
        ObjectInputStream ois = null;
        ArrayList<User> users = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("users")));
            users = (ArrayList<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    /**
     * 打印反序列化出来的对象
     */
    public void printUsers(ArrayList<User> users) {
        if (users != null) {
            for (User user : users) {
                System.out.println(user);
            }
        } else {
            System.out.println("没有数据");
        }
    }


    /**
     * 打印操作和提示信息
     */
    public void printOperationInfo() {
        System.out.println("欢迎：" + userName + "成功进入用户管理系统");
        System.out.println("1、查看用户");

    }

    private void selfInfo() {
    }

    /**
     * 用户注册-判断
     */
    public User userRegister() throws RegisterException {
        if (userName == null || "".equals(userName)) {
            System.out.println("用户名不能为空");
            return null;
        }
        if (userName.length() < 6) {
            throw new RegisterException(userName);
        }
        if (password == null || "".equals(password)) {
            System.out.println("密码不能为空");
            return null;
        }
//        if ('男'.equals(gender) || gender != '女') {
//            System.out.println("没有这样的性别");
//            return null;
//        }
        User user = new User(userName, password, gender);
        return user;
    }


    /**
     * 输入注册/登录信息
     */
    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户名：");
        userName = scanner.next();
        System.out.println("密码：");
        password = scanner.next();
        System.out.println("性别：");
        String temp = scanner.next();
        gender = (char) temp.indexOf(0);
    }



    /**
     * 提示注册
     */
    public void register() {
        System.out.println("请输入注册的信息");
    }

    /**
     * 登录提示
     */
    private void login() {
        System.out.println("请输入登录信息");
    }

    public void judgeLogin() {
//        if(userName.equals())
    }


    public ArrayList<User> InitUsers() throws IOException {
        Random random = new Random();
        String[] familyName = {"张", "刘", "李", "赵", "钱"};
        String[] name = {"一", "万", "前", "花", "从", "注"};
        char[] gender = {'男', '女'};
        ArrayList<User> users = new ArrayList<>();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("users")));
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName(familyName[random.nextInt(familyName.length)] +
                    name[random.nextInt(name.length)] + name[random.nextInt(name.length)]);
            double password = random.nextDouble() * 125.22;
            user.setPassword(Double.toString(password));
            user.setGender(gender[random.nextInt(gender.length)]);
            users.add(user);
        }
        System.out.println("输出初始化信息：");
        for (User user : users) {
            System.out.println(user);
        }
        oos.writeObject(users);
        return users;
    }


}
