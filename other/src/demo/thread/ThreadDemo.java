package demo.thread;

public class ThreadDemo extends Thread {

    private int time = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("线程运行" + time + Thread.currentThread().getName());
            time++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (time == 8) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程" + i+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
