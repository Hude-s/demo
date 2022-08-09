package homework.work12;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PicClientReader extends PicClient implements Runnable {

    private PicClient picClient;

    public PicClientReader(PicClient picClient) {
        this.picClient = picClient;
    }

    /**
     * 接收客户端传来的提示并打印出来   或文档？？
     */
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

    /**
     * 需要不停的监听读取服务器发来的信息进行显示？？？
     */
    public void reader() throws IOException {
        //获取服务器所能进行操作的提示？接收服务端传来的操作提示
        byte[] buff = new byte[1024];
        int len;
        picClient.bos = new ByteArrayOutputStream();
        System.out.println("客户端读取操作启动  " + Thread.currentThread().getName());

        while ((len = picClient.is.read(buff)) != -1) {
            picClient.bos.write(buff, 0, len);
        }
        //输出服务器传来的信息
        System.out.println(picClient.bos.toString());
        /**
         * 释放锁？
         * 关闭流对象？？
         *  *分开关闭
         *  *一个是socket的关闭（最后关闭客户端的时候进行关闭）
         *  *一个是读写流的关闭（每次读取流对象的时候进行关闭）需要关闭的对象有bos,
         *  *
         */
        //通知方法的对象和等待方法的对象要是同一个，若在两个类里面的方法都使用this关键字，
        // 会是分别各自类的对象，就不是同一个对象了，会导致线程死锁，发生超时错误
        synchronized (picClient) {
            picClient.notify();
        }
    }
}
