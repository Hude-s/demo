package tcpdemo.demo1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP 的网络编程
 * 例子1；客户端发送信息给服务端，服务端键数据显示在控制台上
 */

public class TCPTest {
    @Test
    public void client() {
        InetAddress inetAddress = null;
        OutputStream os = null;
        Socket socket = null;
        try {
            inetAddress = InetAddress.getByName("127.0.0.1");
//            boolean reachable = inetAddress.isReachable(1000);
//            System.out.println(reachable);
            socket = new Socket(inetAddress, 9988);

            os = socket.getOutputStream();
            os.write("这里是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流和套接字关闭

            try {
                if (os != null)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (socket != null)
                    socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(9988);
            socket = serverSocket.accept();

            is = socket.getInputStream();
            //不建议这样写，可能会有乱码
            /**
             byte[] buf = new byte[20];
             int len;
             while ((len = is.read(buf)) != -1) {
             String str = new String(buf, 0, len);
             System.out.println(str);
             }*/
            //做缓冲，读取数据
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (baos != null)
                    baos.close();
                if (is != null)
                    is.close();
                if (socket != null)
                    socket.close();
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
