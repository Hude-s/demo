package demo5.entity;

public class User {
    private int userId;
    private String userName;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
