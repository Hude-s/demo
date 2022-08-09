package tcpdemo.demo1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest4 {

    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 9998);

            os = socket.getOutputStream();
            is = socket.getInputStream();

            //文件从内存输出到磁盘
            fos = new FileOutputStream(new File("saveToServer.png"));
            //从磁盘读取文件到内存
            fis = new FileInputStream(new File("beauty1.png"));

            //做数据从磁盘到内存，从内存到输出对象的缓冲
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                //文件数据从文件输入流（文件从磁盘读到内存），向输出流写入
                os.write(buffer, 0, len);
            }

            //关闭socket 的输出
            socket.shutdownOutput();

            //读取从服务器传输来的数据
            byte[] buffer1 = new byte[1024];
            int len1;
            while ((len1 = is.read(buffer1)) != -1) {
                fos.write(buffer1, 0, len1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (fos != null)
                    fos.close();
                if (is != null)
                    is.close();
                if (os != null)
                    os.close();
                if (fis != null)
                    fis.close();
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
        FileInputStream fis = null;
        try {
            serverSocket = new ServerSocket(9998);
            socket = serverSocket.accept();

            is = socket.getInputStream();
            os = socket.getOutputStream();

            fos = new FileOutputStream(new File("saveToClient.png"));

            //从输入流（数据从客户端的输出流os传输到服务端，从服务端的输入流is读取）读取输入的数据is
            //做缓冲
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                //准备输出到文件中，固化到磁盘上，写入到文件输出流对象
                fos.write(buffer, 0, len);
            }

            //准备写出文件
            fis = new FileInputStream(new File("saveToClient.png"));

            byte[] buffer1 = new byte[1024];
            int len1;
            //先把文件从磁盘(读)入到内存（文件输入流对象），再内存（文件入流对象fis）【写】到输出（输出对象os）
            while ((len1 = fis.read(buffer1)) != -1) {
                os.write(buffer1, 0, len1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流

            try {
                if (os != null)
                    os.close();
                if (fis != null)
                    fis.close();
                if (is != null)
                    is.close();
                if (fos != null)
                    fos.close();
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
