package demo.thread.ticket;

public class SellTicket {
    static class SellTicket01 extends Thread {
        private static int ticketNum = 100;

        @Override
        public void run() {
            while (true) {
                if (ticketNum <= 0) {
                    System.out.println("售票结束。。。");
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("窗口 " + Thread.currentThread().getName() + "  售出一张票"
                        + "剩余票数=" + (--ticketNum));
            }
        }
    }

    public static void main(String[] args) {
        SellTicket01 sellTicket01 = new SellTicket01();
        SellTicket01 sellTicket02 = new SellTicket01();
        SellTicket01 sellTicket03 = new SellTicket01();
        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();

    }
}
