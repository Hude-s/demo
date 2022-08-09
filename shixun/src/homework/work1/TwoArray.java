package homework.work1;

public class TwoArray {
    /**
     * 1、定义一个二维数组 8*8 八行八列 int[][] myarr = new int [8][8]
     * 2、使用for循环给数组赋值，赋值为1-64
     * 3、计算对角线上的与元素的平均值
     */
    public static void main(String[] args) {
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

        System.out.println("对角线的平均值为：" + average / count);
    }
}
