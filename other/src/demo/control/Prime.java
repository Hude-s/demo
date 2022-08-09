package demo.control;

public class Prime {
    public static void main(String[] args) {
        Prime p1 = new Prime();
        p1.method(100);
    }

    public void method(int n) {
        int count = 0;
        System.out.print("2到" + n + "的素数有");
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i + "  ");
                count++;
            }
            flag = true;
        }
        System.out.println("\n2到" + n + "的素数的个数为：" + count);
    }

    public void isPrime(int n) {
        int count = 0;
        int i;
        for (i = 2; i < n; i++) {
            if (n % i == 0) {
            } else {
                count++;
                System.out.println(i);
            }
        }
        System.out.println("--------");
        System.out.println(count);
    }


    public void method1(int num1, int num2) {
        int max;
        int min;

        //区分大小
        max = (num1 > num2) ? num1 : num2;
        min = (num2 > num1) ? num1 : num2;

        //计算最大公约数


    }

    int gcd(int a,int b){
        if(a%b==0)
        return b;
        return gcd(b,a%b);
    }
}
