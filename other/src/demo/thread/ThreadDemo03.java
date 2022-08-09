package demo.thread;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo03 {

    /**
     * 4.通过线程池启动多线程
     * 通过Executor 的工具类可以创建三种类型的普通线程池：
     * <p>
     * 固定大小的线程池创建线程测试
     * <p>
     * <p>
     * FixThreadPool(int n); 固定大小的线程池
     * 使用于为了满足资源管理需求而需要限制当前线程数量的场合。使用于负载比较重的服务器。
     */
    public void threadPoolTest() {
        ExecutorService ex = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + "   " + j);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        ex.shutdown();
    }

    /**
     * 单线程池创建线程测试
     * SingleThreadPoolExecutor :单线程池
     * 需要保证顺序执行各个任务的场景
     */
    public void threadPoolTest01() {
        ExecutorService ex = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 6; i++) {
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + "  " + j);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        ex.shutdown();
    }

    /**
     * CashedThreadPool(); 缓存线程池
     * 当提交任务速度高于线程池中任务处理速度时，缓存线程池会不断的创建线程
     * 适用于提交短期的异步小程序，以及负载较轻的服务器
     */
    public void threadPoolTest02() {
        ExecutorService ex = Executors.newCachedThreadPool();
        for (int i = 0; i < 4; i++) {
            ex.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + "  " + j);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        ex.shutdown();
    }

    /**
     * 方法5：创建启动线程之Timer定时任务
     */
    public void threadTest01() {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                System.out.println("定时任务延迟0（立刻执行）,每隔1000ms执行一次   " + Thread.currentThread().getName() + "   " + (count++));
            }
        }, 0, 1000);
    }


    /**
     * 使用Lambda表达式并行计算
     * parallelStream
     *
     * @param list
     * @return
     */
    public int add(List<Integer> list) {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.parallelStream().forEach(System.out::print);
        return list.parallelStream().mapToInt(i -> i).sum();

    }

    public static void main(String[] args) {
        ThreadDemo03 t = new ThreadDemo03();
        //t.threadPoolTest02();
        //t.threadPoolTest01();
        //t.threadPoolTest();
        t.threadTest01();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        ThreadDemo03 t1 = new ThreadDemo03();
        int result = t1.add(list);
        System.out.println("\n计算后的结果为：" + result);
    }
}
