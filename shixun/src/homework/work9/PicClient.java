package homework.work9;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class PicClient implements Runnable {


    @Override
    public void run() {
        while (true) {
            //发送
            try {
                DatagramSocket ds = new DatagramSocket();
                ds.connect(InetAddress.getByName("127.0.0.1"), 6666);

                byte[] bytes = "这里是发送端".getBytes(StandardCharsets.UTF_8);

                DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

                ds.send(packet);
                byte[] buff = new byte[1024];
                packet = new DatagramPacket(buff, buff.length);
                ds.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
