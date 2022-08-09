package demo1;

public class DirectMemoryTest {
    static {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            byte[] arr = new byte[1024 * 1024 * 10];
            System.out.println("创建数组" + i + "次");
        }
    }

    public static void main(String[] args) {
        new DirectMemoryTest();
    }
}
