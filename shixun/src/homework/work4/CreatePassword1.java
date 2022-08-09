package homework.work4;

import java.util.Arrays;
import java.util.Random;

public class CreatePassword1 {

    public static char[] create() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        char[] password_ = new char[8];
        for (int i = 0; i < 3; i++) {
            password_[i] = (char) (random.nextInt(26) + 65);
        }
        for (int i = 3; i < 5; i++) {

            password_[i] = (char) random.nextInt(10);
        }
        for (int i = 5; i < 8; i++) {
            password_[i] = (char) Character.toLowerCase((char) random.nextInt(26) + 65);
        }
        System.out.println(Arrays.toString(password_));
//        System.out.println(password.toString() + "====");
        return password_;
    }

//    //用堆-打乱密码顺序
//    public static String randomToPassword(String password) {
//        char[] password_ = new char[password.length()];
//        for (int i = 0; i < password.length(); i++) {
//            password_[i] = (char) password.charAt(i);
//        }
//        Random random = new Random();
//        for (int i = 0; i < password.length(); i++) {
//            int randomNum = random.nextInt(password.length());
//            char temp = password_[randomNum];
//            password_[randomNum] = password_[i];
//            password_[i] = temp;
//        }
//        password = Arrays.toString(password_);
////        password = password_.toString();
//        return password;
//    }

}
