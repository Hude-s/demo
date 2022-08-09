package tcpdemo.demo1;

import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPTest {
    /**
     * @Test public void sender() throws IOException {
     * InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
     * //数据报对象，创建
     * DatagramSocket ds = new DatagramSocket();
     * ds.setSoTimeout(1000);
     * ds.connect(inetAddress, 9998);
     * //发送数据
     * byte[] data = "这里是发送端发送的数据".getBytes();
     * //数据包对象
     * DatagramPacket packet = new DatagramPacket(data, data.length);
     * <p>
     * //数据报文对象，使用发送方法，将数据包发送出去
     * ds.send(packet);
     * <p>
     * //接收数据
     * byte[] buffer = new byte[1024];
     * packet = new DatagramPacket(buffer, buffer.length);
     * packet.setData(buffer, 0, buffer.length);
     * <p>
     * ds.receive(packet);
     * String resp = new String(packet.getData(),
     * packet.getOffset(), packet.getLength());
     * ds.disconnect();
     * <p>
     * }
     * @Test public void receiver() throws IOException {
     * <p>
     * DatagramSocket ds = new DatagramSocket(9998);
     * for (; ; ) {
     * byte[] buffer = new byte[1024];
     * DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
     * ds.receive(packet);
     * <p>
     * String s = new String(packet.getData(), packet.getOffset(),
     * packet.getLength(), StandardCharsets.UTF_8);
     * byte[] data = "这里是服务端返回的数据".getBytes(StandardCharsets.UTF_8);
     * packet.setData(data);
     * ds.send(packet);
     * }
     * }
     */

    /**
     * @Test public void sender() throws IOException {
     * DatagramSocket ds = new DatagramSocket();
     * ds.connect(InetAddress.getByName("127.0.0.1"), 6666);
     * byte[] data = "hello".getBytes();
     * DatagramPacket packet = new DatagramPacket(data, data.length);
     * ds.send(packet);
     * <p>
     * byte[] buffer = new byte[1024];
     * packet = new DatagramPacket(buffer, buffer.length);
     * <p>
     * ds.receive(packet);
     * String resp = new String(packet.getData(), packet.getOffset(),
     * packet.getLength());
     * <p>
     * System.out.println(resp.toString());
     * ds.disconnect();
     * }
     * @Test public void receiver() throws IOException {
     * DatagramSocket ds = new DatagramSocket(6666);
     * for (; ; ) {
     * byte[] buffer = new byte[1024];
     * DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
     * ds.receive(packet);
     * <p>
     * <p>
     * String s = new String(packet.getData(), packet.getOffset(),
     * packet.getLength(), StandardCharsets.UTF_8);
     * System.out.println(s.toString());
     * byte[] data = "ACK——————".getBytes(StandardCharsets.UTF_8);
     * packet.setData(data);
     * ds.send(packet);
     * }
     * }
     */
    @Test
    public void sender() throws IOException {

        DatagramSocket ds = new DatagramSocket();

        ds.connect(InetAddress.getByName("127.0.0.1"), 9998);

        byte[] bytes = "这里是发送端".getBytes();

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        ds.send(packet);

        //创建缓冲
        byte[] buffer = new byte[1024];
        //创建数据包对象
        packet = new DatagramPacket(buffer, buffer.length);

        ds.receive(packet);


    }

    @Test
    public void receiver() {

    }
}
