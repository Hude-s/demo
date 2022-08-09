package homework.work8.methodTest;

import java.util.function.Supplier;

public class Demo01GetMax {
    //Supplier生产型接口
    public static Integer getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        int[] arr = {15, 46, 48, 92, 116, 13, 45};
        Integer max1 = getMax(() -> {
            int max = arr[0];
            for (int i : arr) {
                if (max < i) {
                    max = i;
                }
            }
            return max;
        });
        System.out.println(max1);
    }
}
