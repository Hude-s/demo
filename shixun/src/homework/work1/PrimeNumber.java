package homework.work1;

import org.junit.Test;

public class PrimeNumber {

    /**
     * 计算2-N的质数？
     */

    public void prime() {
        for (int number = 100; number <= 5000; number++) {
            int i = 2;
            for (; i < number; i++) {
                if (number % i == 0) {
//                    System.out.print(number + "\t");
                    break;
                }
            }
            if (i >= number) {
                System.out.print(number + "\t");
            }
        }
    }

    @Test
    public void test() {
        long start = System.currentTimeMillis();
        prime();
        long end = System.currentTimeMillis();
        System.out.println("\n" + (end - start));
    }
}
