package homework.work3;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class UserService {
    private UserManager userManager;
    private final String filePath = "users";
    private ArrayList<User> users = new ArrayList<>();


    /**
     * 注册
     */
    public boolean register() {
        return false;
    }


    /**
     * 用户注册-判断
     */
    public User userRegister(String userName, String password, char gender) throws RegisterException {
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
//        if ("".equals(gender) || gender != '女') {
//            System.out.println("没有这样的性别");
//            return null;
//        }
        User user = new User(userName, password, gender);
        ArrayList<User> users = getUserList();
        users.add(user);

        return user;
    }


    /**
     * 登录
     */
    public boolean login() {
        return false;
    }


    public boolean judgeLogin(String userName, String password) {
        for (User user : users) {
            if (userName.equals(user.getUserName()) && password.equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<User> initUsers_() {
        Random random = new Random();
        char[] gender = {'男', '女'};
        for (int i = 0; i < 10; i++) {
            User user = new User();
            StringBuilder userName = new StringBuilder();
            StringBuilder password = new StringBuilder();
            for (int j = 0; j < 7; j++) {
                userName.append((char) (random.nextInt(26) + 65));
            }
            for (int j = 0; j < 7; j++) {
                password.append((char) (random.nextInt(26) + 65));
            }
            user.setUserName(userName.toString());
            user.setPassword(password.toString());
            user.setGender(gender[random.nextInt(gender.length)]);
            users.add(user);
        }
        System.out.println("输出初始化信息：");
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    /**
     * 初始化十条用户数据
     */
    public ArrayList<User> addToFile() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (oos != null) {
                oos.writeObject(users);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    public User addUser(ArrayList<User> users) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(filePath)));
            if (users != null) {
                oos.writeObject(users);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public boolean deleteUser() {
        return false;
    }

    public boolean modifyUser() {
        return false;
    }

    public ArrayList<User> showAllUsers() {
        return null;
    }

    public User queryUserByName(String userName) {
        return null;
    }


    /**
     * 将对象从文件中反序列化出来
     */
    public ArrayList<User> getUserList() {
        ObjectInputStream ois = null;
        ArrayList<User> users = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File(filePath)));
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
     * 打印数组对象
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


    public boolean append_serializable(ArrayList<User> users) {
        return false;
    }

    public boolean delete_serializable(ArrayList<User> users) {
        return false;
    }

    public boolean modify_serializable(ArrayList<User> users) {
        return false;
    }


}
