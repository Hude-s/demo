package tcpdemo.demo1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest2 {
    @Test
    public void client() {
        //套接字对象，输出流对象，文件输入流对象(从磁盘读取文件到内存，再交给输出流对象传输到服务器)
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        FileInputStream fis = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 9988);
            //获取socket输出流对象
            os = socket.getOutputStream();
            //输入流，读取服务器的反馈
            is = socket.getInputStream();

            //从磁盘读取到文件到内存
            fis = new FileInputStream(new File("beauty1.png"));

            //设置缓冲数组
            byte[] buffer = new byte[1024];
            int len;
            //将读入的文件数据传给socket输出对象
            while ((len = fis.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            socket.shutdownOutput();

            //读取文件服务器传输来的数据，字节数组输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while ((len1 = is.read(buffer1)) != -1) {
                baos.write(buffer1, 0, len1);
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流对象
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(9988);
            //套接字对象
            socket = serverSocket.accept();

            //输入输出对象流
            is = socket.getInputStream();
            os = socket.getOutputStream();


            //文件输出流,接收客户端使用FileOutputStream发送来的数据文件数据？
//        FileInputStream fis = new FileInputStream(new File("beauty2.png"));
            fos = new FileOutputStream(new File("beauty5.png"));
            //字节数组输出流
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            //构造 文件传输完成响应
            os.write("文件已接收，传输成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
