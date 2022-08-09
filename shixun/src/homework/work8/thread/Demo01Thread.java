package homework.work8.thread;

import java.util.concurrent.ThreadPoolExecutor;

public class Demo01Thread {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        t.run();
        System.out.println(Thread.currentThread().getName() + "  " + "b");

    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            if (Thread.currentThread().getName().equals("main")) {
                Thread.sleep(1000);
            } else {
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  " + "a");
    }
}