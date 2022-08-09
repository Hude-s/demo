package homework.work3;

public class RegisterException extends Exception {
    private static final long serialVersionUID = -81372969369396507L;

    public RegisterException(String message) {
        System.out.println("注册用户名为：" + message + "，长度不能少于6");
    }
}
