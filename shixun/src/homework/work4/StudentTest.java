package homework.work4;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    public static void main(String[] args) {
        ArrayList<Student> students = Student.mergerStudent(Student.students1, Student.students2);
        System.out.println("合并前：");
        System.out.println(Student.students1);
        System.out.println(Student.students2);
        System.out.println("合并后：");
        ArrayList<Student> students1 = new ArrayList<>();
        students1.addAll(Student.students1);
        students1.addAll(Student.students2);
        System.out.println(students1);
        System.out.println("去重后：");
        System.out.println(Arrays.toString(students.toArray()));
    }
}
