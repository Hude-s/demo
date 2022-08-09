package homework.work14;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {

        Account account = new Account();



        CzThread cz1 = new CzThread(account);

        cz1.setName("thread1");

        cz1.start();



        CzThread cz2 = new CzThread(account);

        cz2.setName("thread2");

        cz2.start();

    }

}