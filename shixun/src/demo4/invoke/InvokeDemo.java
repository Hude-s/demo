package demo4.invoke;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class InvokeDemo {


    /*
     * 1. 创建学生类  Student 字段 name age sex hobby    -
     * 2. 编写单元测试方法 读取文件
     * 3. 通过反射技术 把数据文件转化为学生类集合
     *   List<Student>
     * */
    @Test
    public void invokeTest() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //读取文件字符信息
        String sourcePath = "src//demo4//invoke//Students.txt";
        File file = new File(sourcePath);
        FileReader fileReader = new FileReader(file);
        StringBuilder stringBuilder = new StringBuilder();
        int temp;
        while ((temp = fileReader.read()) != -1) {
            stringBuilder.append((char) temp);

        }
        System.out.println(stringBuilder);
        String studentsInfo = stringBuilder.toString();
        String[] studentsInfos = studentsInfo.split(",");
        for (String info : studentsInfos) {
            System.out.print(info);
        }

        Class<?> studentClass = Class.forName("demo4.invoke.Student");

//        Class<Student> studentClass = Student.class;
        Constructor<?> studentClassConstructor = studentClass.getDeclaredConstructor();
        Object o = studentClassConstructor.newInstance();
        System.out.println(studentClassConstructor);
        Student student = null;
        if (o instanceof Student) {
            student = (Student) o;
        }

        Class<Student> studentClass1 = Student.class;

        Method setName = studentClass1.getDeclaredMethod("setName", String.class);
        Method setAge = studentClass1.getDeclaredMethod("setAge", Integer.class);
        Method setSex = studentClass1.getDeclaredMethod("setSex", char.class);
        Method setHobby = studentClass1.getDeclaredMethod("setHobby", String[].class);
//
//        setName.setAccessible(true);
//        setAge.setAccessible(true);
//        setSex.setAccessible(true);
//        setHobby.setAccessible(true);
        Class<ArrayList> arrayListClass = ArrayList.class;
        Constructor<ArrayList> constructor = arrayListClass.getConstructor();
        ArrayList arrayList = constructor.newInstance();

        System.out.println(arrayList);
        for (int i = 0; i < studentsInfos.length ; i++) {
            arrayList.add(student);
        }

        System.out.println(arrayList);
    }


}
