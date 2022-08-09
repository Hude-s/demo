package homework.work3;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * bean对象
 */
public class User implements Serializable {

    private static final long serialVersionUID = 8829427401340732281L;

    private String userName;
    private String password;
    private char gender;

    ArrayList<User> userArrayList = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public User() {
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public User(String userName, String password, char gender) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
    }

//    @Override
//    public boolean equals(Object obj) {
//
//        return false;
//    }
}
