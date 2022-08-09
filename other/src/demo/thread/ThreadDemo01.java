package demo.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadDemo01 implements Callable<Object> {

//    @Override
//    public String call() throws Exception {
//        for (int i = 0; i < 3; i++) {
//            System.out.println("-----");
//            Thread.yield();
//            System.out.println("线程名称：" + Thread.currentThread().getName());
//        }
//        Thread.sleep(1000);
//        return "有返回值的创建线程的方法";
//    }

    /**
     * 使用Callable 接口和 FutureTack 和Thread创建有返回值的线程
     * 注意：可能编写有误，需要修改
     */
    public void futureTaskTest() throws ExecutionException, InterruptedException {
//        Callable<String> callable1 = new ThreadDemo01();//向上转型创建对象
//        FutureTask<String> futureTask = new FutureTask<>(callable1);
//        Thread myThread1 = new Thread(futureTask);
//        Thread myThread2 = new Thread(futureTask);
//        Thread myThread3 = new Thread(futureTask);
//
//        myThread1.setName("t1");
//        myThread2.setName("t2");
//        myThread3.setName("t3");
//
//
//        myThread1.start();
//        System.out.println("=====");
//        myThread2.start();
//        System.out.println("+++++");
//        myThread3.start();
//
//
//        System.out.println(futureTask.get());
    }

    /**
     * 使用匿名内部类创建多线程任务
     * Thread和Runnable闭包创建线程
     * <p>
     * Runnable
     */
    public void threadCreat() {
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Task:" + taskId + ";run time:" + j);
                        System.out.println(Thread.currentThread().getName() + "  " + j);
                    }
                }
            }).start();
        }
    }

    /**
     * 使用匿名内部类创建多线程任务
     * Thread和Runnable闭包创建线程
     * <p>
     * Thread
     */
    public void threadCreat1() {
        for (int i = 0; i < 6; i++) {
            final int taskId1 = i;
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Task:" + taskId1 + ";run time:" + j);
                        System.out.println(Thread.currentThread().getName() + "  " + j);
                    }
                }
            }.start();
        }
    }


    @Override
    public Object call() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "   执行线程为：" + Thread.currentThread().getName());
                sum += i;
            }
//            try {
//                Thread.sleep(123);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Object> call = new ThreadDemo01();
        FutureTask futureTask = new FutureTask(call);
        FutureTask futureTask1 = new FutureTask(call);
        FutureTask futureTask2 = new FutureTask(call);
        FutureTask futureTask3 = new FutureTask(call);
        FutureTask futureTask4 = new FutureTask(call);
        FutureTask futureTask5 = new FutureTask(call);
        FutureTask futureTask6 = new FutureTask(call);
        FutureTask futureTask7 = new FutureTask(call);
        FutureTask futureTask8 = new FutureTask(call);
        FutureTask futureTask9 = new FutureTask(call);
        Thread thread1 = new Thread(futureTask);
        Thread thread2 = new Thread(futureTask1);
        Thread thread3 = new Thread(futureTask2);
        Thread thread4 = new Thread(futureTask3);
        Thread thread5 = new Thread(futureTask4);
        Thread thread6 = new Thread(futureTask5);
        Thread thread7 = new Thread(futureTask6);
        Thread thread8 = new Thread(futureTask7);
        Thread thread9 = new Thread(futureTask8);
        Thread thread10 = new Thread(futureTask9);

        System.out.println("当前线程名为：" + Thread.currentThread().getName());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();

        Object sum = futureTask.get();
        System.out.println("总和为：" + sum);


    }
}
