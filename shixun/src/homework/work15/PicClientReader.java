package homework.work15;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PicClientReader extends PicClient implements Runnable {

    private PicClient picClient;

    public PicClientReader(PicClient picClient) {
        this.picClient = picClient;
    }

    @Override
    public void run() {
        while (true) {
            try {
                reader();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void reader() throws IOException {
        byte[] buff = new byte[1024];
        int len;
        picClient.bos = new ByteArrayOutputStream();
        System.out.println("客户端读取操作启动  " + Thread.currentThread().getName());

        while ((len = picClient.is.read(buff)) != -1) {
            picClient.bos.write(buff, 0, len);
        }
        System.out.println(picClient.bos.toString());
        synchronized (picClient) {
            picClient.notify();
        }
    }
}
