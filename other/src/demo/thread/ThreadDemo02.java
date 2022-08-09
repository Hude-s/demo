package demo.thread;

public class ThreadDemo02 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("线程执行" + (++count) + "  " + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 10) {
                break;
            }
        }

    }

    public static void main(String[] args) {
        ThreadDemo02 threadDemo02 = new ThreadDemo02();
        Thread thread = new Thread(threadDemo02);
        thread.start();
    }
}
