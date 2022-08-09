package demo1.day2;

import java.util.Random;

public class Demo1 {
    public static void main(String[] args) {
        Demo1 d = new Demo1();
        d.m1();
//        d.m2();
    }

    public void m1() {
        Random random = new Random();
        int[] arr = new int[8];
        int[][] arr2 = new int[2][4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(14) + 21;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }

        int k = 0;
        for (int n = 0; n < arr2.length; n++) {
            for (int m = 0; m < arr2[0].length; m++) {
                arr2[n][m] = arr[k];
                k++;
            }
        }
        for (int n = 0; n < 2; n++) {
            for (int m = 0; m < 4; m++) {
                System.out.println(arr2[n][m]);
            }
        }
    }

    public void m2() {
        Random r = new Random();
        int[][] arr1 = new int[2][4];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                arr1[i][j] = r.nextInt(14) + 21;
                for (int k = 0; k < i; k++) {
                    for (int l = 0; l < j; l++) {
                        if (arr1[i][j] == arr1[k][l]) {
                            j--;
                            break;
                        }
                    }
                }
            }
        }

        for (int n = 0; n < 2; n++) {
            for (int m = 0; m < 4; m++) {
                System.out.println(arr1[n][m]);
            }
        }
    }

    public void creat_randomNum(){
        int[] tmp = new int[8];
    }
}

