package rmi.demo3;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private static final long serialVersionUID = 2662759888636006040L;
    private int age;
    private String desc;
    private String userName;
    private boolean sex;

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "age=" + age +
                ", desc='" + desc + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public UserInfo(int age, String desc, String userName, boolean sex) {
        this.age = age;
        this.desc = desc;
        this.userName = userName;
        this.sex = sex;
    }
}
