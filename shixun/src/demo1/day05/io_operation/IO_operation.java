package demo1.day05.io_operation;

import java.io.*;
import java.util.*;

public class IO_operation {

    public IO_operation() {

    }


    public static void main(String[] args) {
        //定义一个数组长度和名字个数一致
        String[] names = null;
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File("E:\\WorkSpace\\idea_work\\实训\\regular_expression\\src\\demo1.day05\\1.txt");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String s = null;

            int count = 0;
            do {
                s = bufferedReader.readLine();
                if (s != null) {
                    System.out.print(s + "\t");
                    count++;
                    //存入List集合
                    arrayList.add(s);
                }
            } while (s != null);
//            while (s != null) {
//                System.out.print(s + "\t");
//                s = bufferedReader.readLine();
//                count++;
//                //存入List集合
//                arrayList.add(s);
//            }
            System.out.println("\n人数：" + count + "\n");

            //集合输出
            System.out.println(Arrays.toString(arrayList.toArray()));
            System.out.println("数组长度" + arrayList.size());

            for (int i = 0; i < arrayList.size(); i++) {
                System.out.print("i:" + i + arrayList.get(i) + "\t");
            }

            //丢到数组里面0-52 共53人
            names = new String[count];
            for (int i = 0; i < count; i++) {
                names[i] = arrayList.get(i);
            }

            System.out.println("\n-------");
            for (String name : names) {
                System.out.print(name + "\t");
            }


            System.out.println("\n=========抽取姓氏=====");
            char[] familyName = new char[count];
            //抽取姓
            for (int i = 0; i < count; i++) {
                familyName[i] = names[i].charAt(0);
            }
            int family_name_count = 0;
            for (char family_name : familyName) {
                family_name_count++;
//                System.out.print(family_name_count+family_name + "\t");
//                System.out.print(family_name + " " + (int) family_name + "\t");
                System.out.print(family_name + " " + family_name_count + "\t");
            }
            System.out.println("\nfamily_name_count = " + family_name_count);


            System.out.println("\t===========HashSet=========");
            //放入HashSet集合去除重复
            HashSet<Character> hashSet_familyName = new HashSet<Character>();
//            for (int i = 0; i < familyName.length; i++) {
//                hashSet_familyName.add(familyName[i]);
//            }
            for (char c : familyName) {
                hashSet_familyName.add(c);
            }

            for (char c : hashSet_familyName) {
                System.out.print(c + "\t");
            }

            System.out.println("hashSet_familyName.size() = " + hashSet_familyName.size());


            System.out.println("\t===========TreeSet=========");
            TreeSet<Character> treeSet_familyName = new TreeSet<Character>();

            for (char c : familyName) {
                treeSet_familyName.add(c);
            }

            for (char c : treeSet_familyName) {
                System.out.print(c + "\t");
            }

            System.out.println("treeSet_familyName.size() = " + treeSet_familyName.size());


            //将姓放入到HashMap中

//            HashMap<Character, String[]> hashMap = new HashMap<>();
//            for (int i = 0; i < familyName.length; i++) {
//                hashMap.put(familyName[i], names);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
