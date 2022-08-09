package homework.work4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CreatePassword {
    static {
        ArrayList<String> passwords = new ArrayList<>();
        System.out.println("生成随机密码：");
        for (int i = 0; i < 5; i++) {
            String password = create();
            System.out.println(password);
            password = randomToPassword(password);
            passwords.add(password);
        }
        System.out.println("打乱密码顺序后：");
        for (String password : passwords) {
            System.out.println(password);
        }
    }

    public static String create() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            password.append((char) (random.nextInt(26) + 65));
        }
        for (int i = 0; i < 2; i++) {
            password.append(random.nextInt(10));
        }
        for (int i = 0; i < 3; i++) {
            password.append(Character.toLowerCase((char) (random.nextInt(26) + 65)));
        }
        return password.toString();
    }

    public static String randomToPassword(String password) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] password_ = new char[password.length()];
        for (int i = 0; i < password.length(); i++) {
            password_[i] = (char) password.charAt(i);
        }
        Random random = new Random();
        for (int i = 0; i < password.length(); i++) {
            int randomNum = random.nextInt(password.length());
            char temp = password_[randomNum];
            password_[randomNum] = password_[i];
            password_[i] = temp;
        }
        for (char c : password_) {
            stringBuilder.append(c);
        }
        password = stringBuilder + "";

        return password;
    }

}
