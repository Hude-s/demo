package homework.work8.thread;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo1 {
    public static void main(String[] args) {
        MyThread1.test();
    }
}

/**
 * 使用线程池实现卖票案例 并统计 各个窗口卖出的的票数
 */
class MyThread1 extends Thread {
    public static int ticket = 100;
    private static volatile boolean flag = false;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (ticket != 0) {
                ticket -= 1;
            }
        }
    }

    static int ticket1 = 100;

    public static void test() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        HashMap<String, Integer> saleTicket = new HashMap<>();
        Lock lock = new ReentrantLock();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                int sale = 0;
                for (int j = 0; j < 101; j++) {
                    lock.lock();
                    try {
                        if (ticket != 0) {
                            ticket--;
                            saleTicket.put(Thread.currentThread().getName(), ++sale);
                            Thread.sleep(10);
//                            System.out.println(saleTicket.get(Thread.currentThread().getName()));
                        } else if (ticket == 0) {
                            flag = true;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });


        threadPool.submit(t);
        threadPool.submit(t);
        threadPool.submit(t);
        System.out.println("========");
        while (true) {
            if (flag) {
                int sum = 0;
                for (String key : saleTicket.keySet()) {
                    System.out.println(key + " " + saleTicket.get(key));
                    Integer a = saleTicket.get(key);
                    sum += a;
                }
                System.out.println(sum);
                System.exit(0);
            }
        }
    }

}
