package demo1.day2;

public class Day2_2 {
    public static void main(String[] args) {
        Day2_2 d1 = new Day2_2();
        d1.method();

    }

    public void method() {
        int[][] myArr = new int[8][8];
        double average = 0;
        int value = 1;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                myArr[i][j] = value++;
                System.out.print(myArr[i][j] + "\t");
                if (j == 7) {
                    System.out.print("\n");
                }
                if (i == j) {
                    count++;
                    average += myArr[i][j];
                }
            }
        }

        System.out.println("对角线的平均值为："+average/count);
    }
}
