package homework.work8.thread2;

public class TestVolatile {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        TestVolatile t = new TestVolatile();
        t.test();
    }

    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (flag) {
                        System.out.println("线程A");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        flag = false;
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!flag) {
                        System.out.println("线程B");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        flag = true;
                    }
                }
            }
        }).start();
    }

    public void test1() {
        new Thread(() -> {
            while (true) {
                if (flag) {
                    System.out.println("线程A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = false;
                }
            }
        }
        ).start();

        new Thread(() -> {
            while (true) {
                if (!flag) {
                    System.out.println("线程B");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = true;
                }
            }
        }
        ).start();
    }
}
