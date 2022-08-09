package demo2.tcp2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class PicServer {

    ServerSocket serverSocket = null;
    Socket socket = null;
    InputStream is = null;
    OutputStream os = null;
    ByteArrayOutputStream bos = null;
    ByteArrayInputStream bis = null;

    //开启连接监听
    public void getConnect() throws IOException {
        serverSocket = new ServerSocket(9999);

    }

    //获取socket-IO流
    public void getIO() throws IOException {
        is = socket.getInputStream();
        os = socket.getOutputStream();
    }

    //关闭二进制流
    public void closeBinaryIO() throws IOException {
        if (bos != null) {
            bos.close();
        }
        if (bis != null) {
            bis.close();
        }
    }

    //关闭socket流
    public void closeIO() throws IOException {
        if (is != null) {
            is.close();
        }
        if (os != null) {
            os.close();
        }
    }

    //关闭连接
    public void closeSocket() throws IOException {
        if (socket != null) {
            socket.close();
        }
        if (serverSocket != null) {
            serverSocket.close();
        }
    }


    //发送信息
    public void sender() throws IOException {

        String str = "---------欢迎使用韶关学院控制台版本图片服务器(client)-------\n" +
                "1.浏览服务器图片(显示图片名列表)\n" +
                "2.上传图片到服务器\n" +
                "3.下载图片到本地\n";

        byte[] notice = str.getBytes();
        System.out.println("服务器写操作启动  " + Thread.currentThread().getName());
        os.write(notice);
        os.flush();
    }


    public void receiver() throws IOException {
        while (true) {
            int len;
            byte[] buff = new byte[1024];
            bos = new ByteArrayOutputStream();
            while ((len = is.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            System.out.println(bos.toString());
        }
    }

    public void operation() throws IOException {
        getConnect();
        while (true) {
            socket = serverSocket.accept();
            new Thread(() -> {
                try {
                    getIO();
                    sender();
                    closeBinaryIO();
                    Thread.sleep(5000);
                    os.flush();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    synchronized (this) {
                        this.notify();
                    }
                }
            }).start();

            new Thread(() -> {
                try {
                    getIO();
                    receiver();
                    closeBinaryIO();
                    is.close();
                    Thread.sleep(5000);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    synchronized (this) {
                        this.notify();
                    }
                }
            }).start();
            try {
                synchronized (this) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
