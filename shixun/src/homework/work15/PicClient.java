package homework.work15;

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

    public void connect() {
        try {
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
            closeBinary();
        }
    }

    public void openReaderThread() {
        PicClientReader reader = new PicClientReader(this);
        Thread t = new Thread(reader);
        t.start();
    }

    //获取socket输入输出流
    public void getFlow() {
        System.out.println("获取socket输入输出流...");
        try {

            is = socket.getInputStream();
            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //关闭二进制输入输出流和socket输入输出流
    public void closeFlow() {
        System.out.println("socket输入输出流关闭...");
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
    }


    public void closeBinary(){
        System.out.println("关闭二进制流...");
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
        System.out.println("关闭socket连接...");
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
