package homework.work8.thread2;

import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new WaitThread(), "waitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new NotifyThread());
        notifyThread.start();
    }

    static class WaitThread implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    System.out.println("flag为true,不满足条件，继续等待");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("flag为false,我要从wait状态返回继续执行了");
                }
            }
        }
    }

    static class NotifyThread implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                lock.notifyAll();
            }
            System.out.println("设置flag为false，我发出了通知,但是不会立马释放锁");
            flag = false;
        }
    }
}
