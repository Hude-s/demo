package demo1.serialize_;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 4714970388941766326L;

    private String name;
    private int age;
    private char gender;
    private String hobby;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
