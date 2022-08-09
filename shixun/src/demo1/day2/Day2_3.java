package demo1.day2;

import java.util.Random;

public class Day2_3 {
    public static void main(String[] args) {
        Day2_3 d = new Day2_3();
    }

    public void method() {
        int[][] arr = new int[2][4];
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int randomNum = random.nextInt(14) + 21;
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 4; k++) {

                    arr[j][k] = randomNum;
                }
            }
        }
    }

//    public void method1() {
//        int[][] arr1 = new int[2][4];
//
//
//
//        boolean flag = true;
//        int temp;
//        for(int k=0;k<8;k++){
//            //生成随机数
//            temp = random.nextInt();
//            //判断重复问题
//            for(int i=0;i<2;i++){
//                for(int j=0;j<4;j++){
//                    if(arr1[i][j]==temp){
//                        flag = false;
//                        break;
//                    }
//                }
//            }
//        }
//    }
    public void creat_random(){
        Random random = new Random();

        int[] randomNum = new int[8];
    }


}
