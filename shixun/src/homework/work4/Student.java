package homework.work4;

import java.util.ArrayList;

public class Student {
    private String name;
    private int age;
    static ArrayList<Student> students1 = new ArrayList<>();
    static ArrayList<Student> students2 = new ArrayList<>();


    static {
        Student student = new Student();
        student.name = "小明";
        student.age = 18;
        Student student1 = new Student();
        student1.name = "小黑";
        student1.age = 18;
        students1.add(student);
        students1.add(student1);

        Student student2 = new Student();
        student2.name = "小白";
        student2.age = 19;
        Student student3 = new Student();
        student3.name = "小明";
        student3.age = 18;
        students2.add(student2);
        students2.add(student3);
        students2.add(student2);
        students2.add(student2);
        students2.add(student2);
    }

    //合并
    public static ArrayList<Student> mergerStudent(ArrayList<Student> students1, ArrayList<Student> students2) {
        ArrayList<Student> students = new ArrayList<>();
        students.addAll(students1);
        students.addAll(students2);

        //去重
        ArrayList<Student> students_ = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            boolean isTrue = true;
            for (int j = i + 1; j < students.size(); j++) {
                if (students.get(i).name.equals(students.get(j).name) && students.get(i).age == students.get(j).age) {
                    isTrue = false;
                    break;
                }
            }
            if(isTrue){
                students_.add(students.get(i));
            }
        }
        return students_;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
