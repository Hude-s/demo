package homework.work13;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PicClientWrite extends PicClient implements Runnable {
    private PicClient picClient;

    public PicClientWrite(PicClient picClient) {
        this.picClient = picClient;
    }

    @Override
    public void run() {
        while (true) {
            clientWrite();
        }
    }


    public void clientWrite() {
        try {
            picClient.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        String sendContent = scanner.next();
        System.out.println("客户端写操作启动    " + Thread.currentThread().getName());
        try {
            os.write(sendContent.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        picClient.notify();
    }


}
