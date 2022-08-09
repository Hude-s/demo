package homework.work5;

public class RegisterException extends Exception {
    private static final long serialVersionUID = -8381948646591516888L;

    public RegisterException(String message) {
        System.out.println("输入的用户名:" + message + "少于6位");
    }
}
