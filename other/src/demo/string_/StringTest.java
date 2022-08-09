package demo.string_;

public class StringTest {
    public static void main(String[] args) {
        method1();
    }

    public static class Student {
        String name;
        char gender;
        int age;

        public Student(String name, char gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }
    }

    public static void method1() {
        StringBuilder sb = new StringBuilder(10);

        Student student = new Student("zhang", '男', 19);
        boolean a = true;
        sb.append("Runoob..");
        System.out.println(sb);
        sb.append(a);
        sb.append(student.toString());
        sb.append("!");
        System.out.println(sb);
        sb.insert(8, "java");
        System.out.println(sb.capacity());
        System.out.println(sb);
        sb.delete(5, 8);
        System.out.println(sb);

        float floatVar = 10.02F;
        int intVar = 12;
        String stringVar = "aaa";

        System.out.printf("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                "is %s", floatVar, intVar, stringVar + "\n");

        System.out.println("--------");
        String sf;
        sf = String.format("浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                "is %s", floatVar, intVar, stringVar);

        System.out.println("=========");
        System.out.println(sf);
    }

    public static void method2() {
        StringBuffer sBuffer = new StringBuffer("菜鸟教程官网：");
        sBuffer.append("www");
        sBuffer.append(".runoob");
        sBuffer.append(".com");
        System.out.println(sBuffer);
    }

}
