package demo.algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class AlgorithmDemo {
    public static void main(String[] args) {
        int[] array = {0, 2, 4, 6, 8};//定义传入的数组
        Solution solution = new Solution();
        System.out.println("array = " + Arrays.toString(array));
        int[] ints = solution.twoSum(array, 14);//调用方法，返回数值
        for (int i = 0; i < ints.length; i++) {//输出
            System.out.print(ints[i] + " ");
        }
    }
}

class Solution {

    public int[] twoSum(int[] numbers, int target) {
        HashMap map = new HashMap();
        int rest;
        //计算出余数，放入集合
        for (int i = 0; i < numbers.length; i++) {
            rest = target - numbers[i];
            map.put(i, rest);
        }
        //定义返回数组
        int temp = 0;
        int[] back = new int[2];
        System.out.println("map.toString() = " + map.toString());

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsValue(numbers[i])) {
                temp = i;
            }
        }

        System.out.println("temp = " + temp);
        int temp1 = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == (target - numbers[temp])) {
                temp1 = i;
            }
        }
        System.out.println("temp1 = " + temp1);
        back[0] = Math.min(temp, temp1);
        back[1] = Math.max(temp, temp1);
        return back;
    }
}