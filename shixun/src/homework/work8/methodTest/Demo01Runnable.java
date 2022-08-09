package homework.work8.methodTest;

public class Demo01Runnable {
    public static void run(Runnable run) {
        new Thread(run).start();
    }

    public static void main(String[] args) {
        //使用匿名内部类
        run(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        //超过一行不能简化花括号
        run(() -> {
            System.out.println("====");
            System.out.println(Thread.currentThread().getName());
        });

        //仅有一行时可以简化花括号，方法的参数是一个函数式接口，可以使用lambda对其进行代码优化
        /**
         * 方法的参数是函数式接口，可以使用匿名内部类
         * 方法的返回值是接口，可以返回匿名内部类
         * 返回值是函数式接口，可以使用lambda表达式
         */
        run(() -> System.out.println(Thread.currentThread().getName()));
    }
}
