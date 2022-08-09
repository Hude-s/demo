package demo1.day2;

import java.util.Random;

public class Demo2 {
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        for (int i = 0; i < 100; i++) {
            demo2.rep();
        }
    }

    public void countTest() {
        Demo2 demo2 = new Demo2();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
//        for (int j = 0; j < arr.length; j++) {
//            System.out.print(arr[j]);
//        }
        demo2.outArr(arr);
        int index = demo2.search_binary(arr, 0, arr.length - 1, 1);
        if (index != -1)
            System.out.println(index);
        System.out.println(demo2.count);
    }

    public void rep() {
        final int N = 10;
        Demo2 demo2 = new Demo2();
        int[] arr = demo2.m1(N);
//        demo2.outArr(arr);
        System.out.println("=======");
//        arr = demo2.sort_bubble(arr);
//        arr = demo2.sort_quick(arr, 0, arr.length - 1);
        arr = demo2.sort_choice(arr);
        demo2.outArr(arr);
        int result = demo2.search_binary(arr, 0, arr.length - 1, 421);
        System.out.println("result" + result);
        if (result != -1) {
            System.out.println("-----========================-----------???????????????????????????");
        }
        System.out.println(demo2.count);
    }

    //创建随机数组
    public int[] m1(int N) {
        int[] arr = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(100) + random.nextInt(777);
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }
        return arr;
    }

    //数组输出
    public void outArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
            if ((i + 1) % 10 == 0) {
                System.out.print("\n");
            }
        }
    }

    //冒泡排序
    public int[] sort_bubble(int[] arr) {
        System.out.println("冒泡排序");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    //快速排序
    public int[] sort_quick(int[] arr, int l, int r) {
        if (l < r) {
            int i = l, j = r, x = arr[l];
            while (i < j) {
                while (i < j && arr[j] >= x)
                    j--;
                if (i < j)
                    arr[i++] = arr[j];
                while (i < j && arr[i] < x)
                    i++;
                if (i < j)
                    arr[j--] = arr[i];
            }
            arr[i] = x;
            sort_quick(arr, l, i - 1);
            sort_quick(arr, i + 1, r);
        }
        return arr;
    }

    public int[] sort_choice(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //最小数值位置初始化
            int min = i;
            //每轮需要比较的次数N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    //记录更小的数值位置
                    min = j;
                }
            }
            //将找到最小的i 位置所在的值进行交换
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

    int count = 0;

    public int search_binary(int[] arr, int start, int end, int target) {

        if (arr != null) {
            if (start > end) {
                return -1;
            }
            count++;
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
//                count++;
                return search_binary(arr, start, mid - 1, target);
            } else if (target > arr[mid]) {
//                count++;
                return search_binary(arr, mid + 1, end, target);
            }
        }
        return -1;
    }

}
