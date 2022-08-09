package demo7;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.util.Arrays;

public class MemoryMonitor {

    @Test
    public void test() {
        try {
            System.out.println("程序开始....");
            Thread.sleep(10000);
            System.out.println("程序已加载....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count = 0;
        while (count < 5000) {
            new MemoryMonitorInstance(count);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
        System.out.println("程序结束");
    }

    /**
     * 查看对象头信息
     */
    @Test
    public void ObjectTest() {

        MemoryMonitorInstance m = new MemoryMonitorInstance(1);
        String[] s = new String[10];
        System.out.println("before......");
        System.out.println(ClassLayout.parseInstance(m).toPrintable());
        System.out.println("---------------------------------------");
        System.out.println(ClassLayout.parseInstance(s).toPrintable());
        System.out.println("after......");
        System.out.println(m.hashCode());
        System.out.println(s.hashCode());
//        System.out.println(Arrays.hashCode(s));
        System.out.println(ClassLayout.parseInstance(m).toPrintable());
        System.out.println("---------------------------------------");
        System.out.println(ClassLayout.parseInstance(s).toPrintable());
    }

    /**
     * CAS 比较和交换Compare And Swap
     */
    @Test
    public void CompareTest(){

    }


    //获取Unsafe对象
//    public static Unsafe getUnsafe(){
//        return Unsafe.getUnsafe();
//    }
//    public static Unsafe getUnsafe1(){
//        return null;
//    }
}
