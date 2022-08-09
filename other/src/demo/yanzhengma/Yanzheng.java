package demo.yanzhengma;

import java.util.Random;

public class Yanzheng {

//    public void m1() {
//        char[] a = new char[5];
//        Random random = new Random();
//        for (int i = 0; i < a.length; i++) {
//            int l = random.nextInt(24) + 65;
//            if (i == a.length - 1) {
//                l = random.nextInt(10);
//            }
//            boolean randomNum = random.nextBoolean();
//            char b = 'A';
//            if (i < a.length - 1) {
//                b = (char) l;
//            }
//            if (randomNum) {
//                b = Character.toLowerCase(b);
//            }
//            a[i] = b;
//            System.out.print(" " + a[i]);
//        }
//    }

    public void m2() {
        char[] a = new char[4];
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            int l = random.nextInt(26) + 65;
            char b = (char) l;
            boolean randomNum = random.nextBoolean();
            if (randomNum) {
                b = Character.toLowerCase(b);
            }
            a[i] = b;
//            System.out.print(" " + a[i]);
            stringBuffer.append(a[i]);
        }
        int lastNum = random.nextInt(10);
        stringBuffer.append(lastNum);
        System.out.println("\nstringBuffer.toString() = " + stringBuffer.toString());
    }

    public static void main(String[] args) {
        Yanzheng yz = new Yanzheng();
        yz.m2();
    }
}
