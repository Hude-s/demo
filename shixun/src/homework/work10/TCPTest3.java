package homework.work10;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 北渊
 * @version 1.0
 * @description: TODO  * 从客户端发送文件给服务器，服务端保存到本地。并返回“发送成功”给客户端
 *                       并关闭相关的连接
 * @date 2022/7/2 14:54
 */
public class TCPTest3 {
    //1.创建Socket对象，指明服务器端的ip和端口号                    //1.创建服务器端的ServerSocket，指明自己的端口号
    //2.获取一个输出流，用于输出数据                               //2.调用accept（）表示接受来自客户端的socket
    //3.写出数据                                               //3.获取一个输入流
    //4.资源的关闭                                             //4.读取输入流中的数据
                                                             //5.资源的关闭

    @Test
    public void client(){

        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress,9090);

            outputStream = socket.getOutputStream();

            fileInputStream = new FileInputStream(new File("wallhaven-1k36vg.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while( (len = fileInputStream.read(buffer)) != -1 ){
                outputStream.write(buffer,0,len);
            }

            // 关闭数据的输出
            socket.shutdownOutput();

            // 接收来自于服务器端的数据，并显示到控制台上
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[20];
            int len1;
            while ((len1 = inputStream.read(buffer1)) != -1) {
                byteArrayOutputStream.write(buffer1, 0, len1);
            }

            System.out.println(byteArrayOutputStream.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if ( fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
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


    //1.创建Socket对象，指明服务器端的ip和端口号                    //1.创建服务器端的ServerSocket，指明自己的端口号
    //2.获取一个输出流，用于输出数据                               //2.调用accept（）表示接受来自客户端的socket
    //3.写出数据                                               //3.获取一个输入流
    //4.资源的关闭                                             //4.读取输入流中的数据
    //5.资源的关闭

    @Test
    public void server(){

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(9090);
            //2.调用accept（）表示接受来自客户端的socket
            socket = serverSocket.accept();
            //3.获取一个输入流，接受客服端发送的文件
            inputStream = socket.getInputStream();
            //4.获取FileOutputStream，将客户端发送的文件保存在本地
            fileOutputStream = new FileOutputStream("clientFile.jpg");

            byte[] buffer = new byte[1024];
            int len;

            while ( (len = inputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }

            //5.服务器段给客户端反馈
            outputStream = socket.getOutputStream();
            outputStream.write("收到文件！".getBytes());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if ( inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if ( outputStream != null) {
                try {
                    outputStream.close();
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
