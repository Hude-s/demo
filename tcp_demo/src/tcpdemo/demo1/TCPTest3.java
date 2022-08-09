package tcpdemo.demo1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest3 {
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 9998);
            os = socket.getOutputStream();
            is = socket.getInputStream();

            //将要传送的文件加载到内存，将文件发送到服务器
            fis = new FileInputStream(new File("beauty1.png"));
            //加传输缓冲
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            //关闭传输
            socket.shutdownOutput();

            //读取,服务器传输过来的数据
            baos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while ((len1 = is.read(buffer1)) != -1) {
                baos.write(buffer1, 0, len1);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流

            try {
                if (baos != null)
                    baos.close();
                if (os != null)
                    os.close();
                if (fis != null)
                    fis.close();
                if (is != null)
                    is.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        FileOutputStream fos = null;
        try {
            serverSocket = new ServerSocket(9998);
            socket = serverSocket.accept();

            is = socket.getInputStream();
            os = socket.getOutputStream();

            //将文件写到磁盘
            fos = new FileOutputStream(new File("beauty2.png"));

            //准备缓存，读取客户端传输来的数据
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                //将客户端传输来的数据写入到文件输出流对象中，固化到磁盘
                fos.write(buffer, 0, len);
            }

            //完成传输，对客户端进行返回响应
            os.write("传输的数据已收到，传输成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流

            try {
                if (os != null)
                    os.close();
                if ((fos != null))
                    fos.close();
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
