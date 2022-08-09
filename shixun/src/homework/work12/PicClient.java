package homework.work12;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class PicClient {
    Socket socket = null;
    InetAddress inetAddress = null;
    InputStream is = null;
    OutputStream os = null;
    ByteArrayOutputStream bos = null;
    ByteArrayInputStream bis = null;

    Object object = new Object();

    /**
     * 获取与服务器的连接
     */
    public void connect() {
        try {
            //获取和服务器的连接
            inetAddress = InetAddress.getByName("localhost");
            socket = new Socket(inetAddress, 8989);

            getFlow();
            openReaderThread();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                synchronized (this) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("客户端关闭流（二进制和socket输入输出流）..." + Thread.currentThread().getName());
            closeFlow();
        }
    }

    public void openReaderThread() {
        System.out.println("客户端开启..." + Thread.currentThread().getName());
        //开启子线程
        PicClientReader reader = new PicClientReader(this);
        Thread t = new Thread(reader);
        t.start();
    }

    //获取socket输入输出流
    public void getFlow() {
        try {
            //获取与服务器通信的输入输出流
            //优化——》写成工具类或方法？+配置文件？
            is = socket.getInputStream();
            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //关闭二进制输入输出流和socket输入输出流
    public void closeFlow() {
        if (os != null) {
            try {
                os.close();
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
        if (bos != null) {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bis != null) {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //关闭socket连接
    public void closeConnect() {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
