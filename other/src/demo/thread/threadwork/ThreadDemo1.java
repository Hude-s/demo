package demo.thread.threadwork;

public class ThreadDemo1 {
    public static void main(String[] args) {
        User user1 = new User("user1");
        User user2 = new User("user2");
        user1.start();
        user2.start();
    }
}

class User extends Thread {
    private String userName;
    private static int money = 10000;
    private boolean loop = true;

    public User(String userName) {
        this.userName = userName;
    }

    public static void setMoney(int money) {
        User.money = money;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public synchronized void run() {
        while (loop) {
            try {
                if (money < 1000) {
                    loop = false;
                    System.out.println("钱已经取完");
                    break;
                }
                System.out.println(userName + "取走了1000,还剩 =" + money + "线程：" + Thread.currentThread().getName());
                money -= 1000;
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


