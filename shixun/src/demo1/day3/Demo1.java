package demo1.day3;

import java.util.Random;

public class Demo1 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        //1，生成1-9的随机数 存储到一个长度为6的数组
        initArr(arr);

        //2，打印数组中的元素 格式{elem1,elem2...}
        printArr(arr);

        //3，定义一个方法获得最大值
        int max = getArrMax(arr);
        System.out.println("数组最大值为：" + max);

        //4,定义一个方法，输入一个元素，查找这个元素位置
        int target = 3;
        int index = queryElem(arr, target);
        if (index != -1) {
            System.out.println("查找的元素存在，下标位置是" + index);
        }

    }

    public static int queryElem(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                index = i;
            }
        }
        return index;
    }


    public static int getArrMax(int[] arr) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }


    //初始化
    public static void initArr(int[] arr) {
        Random random = new Random();
        if (arr == null || arr.length == 0) {
            return;
        }
        //初始化数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(9) + 1;
        }
    }

    //遍历打印
    public static void printArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        //拼接字符串
        StringBuilder builder = new StringBuilder("{");

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                builder.append(arr[i]).append("}");
            } else {
                builder.append(arr[i]).append(",");
            }
        }
        System.out.println(builder.toString());

//        for (int j = 0; j < arr.length; j++) {
//            System.out.print(arr[j]);
//        }
//        for (int i : arr) {
//            System.out.println(i);
//        }
    }

}
