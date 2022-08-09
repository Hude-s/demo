package demo.thread.threadwork;

public class ThreadDemo2 {
    public static void main(String[] args) {
        T t = new T();
        Thread thread1 = new Thread(t);
        Thread thread2 = new Thread(t);
        thread1.setName("t1");
        thread2.setName("t2");
        thread1.start();
        thread2.start();

    }
}

//因为这里涉及到多个线程共享资源的问题，所以我们实现Runnable方式
class T implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {

            //解读
            //1、这里使用synchronized 实现了线程同步
            //2、当多个线程执行到这里时，就会去争夺this对象锁
            //3、哪个线程争夺到（获取）this对象
            synchronized (this) {
                //判断余额是否够
                if (money < 1000) {
                    System.out.println("余额不足");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取出了1000,当前余额=" + money);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
