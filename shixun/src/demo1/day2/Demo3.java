package demo1.day2;

import java.util.Random;

public class Demo3 {
    public static void main(String[] args) {
        //1,定义一个生成随机数的类
        Random random = new Random();
        //2,定义一个数组长度是8
        int[] arr = new int[8];
        int[][] arrTwo = new int[4][8];
        for (int n = 0; n < arrTwo.length; n++) {
            //3,循环8次，生成8个随机数
            for (int i = 0; i < arr.length; i++) {
                //4，先生成一个随机数 放在第一位 肯定不会重复
                int randNumber = random.nextInt(15) + 21;//[0,14]+21=[21,35]
                if (i == 0) {
                    arr[i] = randNumber;
                    //结束本次循环
                    continue;
                }

                //从i=1的时候需要判断生成的随机数是否会重复
                boolean flag = false;
                for (int j = 0; j < arr.length; j++) {
                    if (randNumber == arr[j]) {
                        flag = true;
                        break;
                    }
                }
                //本次生成的随机数无效
                if (flag) {
                    i--;
                } else {
                    arr[i] = randNumber;
                    arrTwo[n][i] = arr[i];
                }
            }
        }

//        for (int[] arr1 : arrTwo) {
//            for (int arr2 : arr1) {
//                System.out.println(arr2);
//            }
//        }

//        for (int[] a : arrTwo) {   //int[]是二维数组中元素的类型 a是迭代变量   arr是二维数组的名称
//            for (int i : a) {    //int,一维数组的类型，i是迭代变量，a是一维数组的名称
//                System.out.print(i + "\t");
//            }
//            System.out.println();
//        }

        for(int [] b: arrTwo){
            for(int j = 0;j<b.length;j++){
                System.out.print(b[j]+"\t");
            }
            System.out.println();

        }
    }
}
