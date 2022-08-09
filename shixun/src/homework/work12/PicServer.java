package homework.work12;

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

    public void connect() {
        try {
            //创建服务器开放的服务端口，并进行监听  ？问题个客户端连接过来的请求处理？下载文件请求的？多线程？
            serverSocket = new ServerSocket(8989);
            socket = serverSocket.accept();

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
            System.out.println("服务器关闭流（二进制和socket输入输出流）..." + Thread.currentThread().getName());
            closeFlow();
        }
    }

    //开启服务器写线程
    public void openReaderThread() {
        /**
         * 问题：主线程开启子线程后，继续往下执行了，关闭了socket，子线程因为主线程关闭socket导致了错误
         * 处理：让主线程等待子线程完成后再进行（执行）关闭流操作，
         *      * 开启锁机制？
         *      * 等待机制 ？
         *      *
         */
        System.out.println("服务器开启..." + Thread.currentThread().getName());
        PicServerWriter writer = new PicServerWriter(this);
        Thread t = new Thread(writer);
        t.start();
    }

    //获取socket的输入输出流
    public void getFlow() {
        //获取向客户端通信的输入输出流对象
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //关闭二进制输入输出流和socket的输入输出流
    public void closeFlow() {
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
    }

    //关闭socket和serverSocket的连接
    public void closeConnect() {
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
