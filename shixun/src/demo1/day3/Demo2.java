package demo1.day3;

import java.util.Arrays;

//斐波那契数列
public class Demo2 {
    public static void main(String[] args) {
        int[] rabbitArr = new int[20];
//        第一第二个月赋值1
        rabbitArr[0] = 1;
        rabbitArr[1] = 1;

        //
        for (int i = 2; i < rabbitArr.length; i++) {
            rabbitArr[i] = rabbitArr[i - 1] + rabbitArr[i - 2];
        }

        System.out.println("兔子数组是"+Arrays.toString(rabbitArr));


    }
}
