package demo6;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    @org.junit.Test
    public void test() throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        File file = new File("exception.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        Class<Calculate> calculateClass = Calculate.class;

        Calculate calculate = calculateClass.newInstance();
        Properties p = new Properties();
        FileInputStream f = new FileInputStream("p.properties");
        p.load(f);
        Object annotation = p.get("Annotation");

        System.out.println(annotation);
        Class<?> aClass = Class.forName(annotation.toString());


        Class<Che> cheClass = Che.class;
        Che che = cheClass.newInstance();
        System.out.println(che);

        System.out.println(cheClass);

        Calculate c = new Calculate();
//        Class<? extends Calculate> calculateClass = c.getClass();
        Method[] methods = calculateClass.getDeclaredMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent((Class<? extends Annotation>) aClass)){
                System.out.println(method);
                try {
                    method.invoke(calculate,10,0);
                } catch (InvocationTargetException e) {
                    bw.write(e.getCause().getMessage());
                }
            }
        }
        bw.flush();
        bw.close();
    }

}
