package demo4.invoke;

import java.util.Arrays;

public class Student {
    private String name;
    private Integer age;
    private char sex;
    private String[] hobby;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String[] getHobby() {
        return hobby;
    }

    public Student() {
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public Student(String name, Integer age, char sex, String[] hobby) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.hobby = hobby;
    }
}
