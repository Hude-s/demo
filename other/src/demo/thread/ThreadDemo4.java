package demo.thread;

import java.util.concurrent.*;

public class ThreadDemo4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(6);

        Callable<Integer> callable = new Callable<Integer>() {
            int sum;

            @Override
            public Integer call() throws Exception {
                for (int i = 0; i < 101; i++) {
                    System.out.println(Thread.currentThread().getName());
                    sum += i;
                    Thread.sleep(1000);
                }
                return sum;
            }
        };

        Future<Integer> future = threadPool.submit(callable);
        System.out.println(future.get());
    }
}
