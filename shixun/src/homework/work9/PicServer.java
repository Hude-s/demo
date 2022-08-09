package homework.work9;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class PicServer implements Runnable {

    @Override
    public void run() {
        try {
            DatagramSocket ds = new DatagramSocket(6666);
            while (true) {
                //接收
                byte[] buff = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buff, 0, buff.length);
                ds.receive(packet);


                String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
                System.out.println("客户端：" + s.toString());

                //线程信息
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());

                //发送
                byte[] data = "ACK----".getBytes(StandardCharsets.UTF_8);
                packet.setData(data);
                ds.send(packet);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PicServer picServer = new PicServer();
        Thread t = new Thread(picServer);
        t.start();
    }
}
