package homework.work10;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * @author 北渊
 * @version 1.0
 * @description: TODO ；例题二：客户段发送文件给服务端，服务端将文件保存在本地
 * @date 2022/7/2 14:22
 */
public class TCPTest2 {

    //client                                                     server
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
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            //1.创建Socket对象，指明服务器端的ip和端口号
            socket = new Socket(inetAddress,9090);
            //2.获取一个输出流，用于输出数据
            outputStream = socket.getOutputStream();
            //3.获取一个文件输入流，指定要发送的文件
            fileInputStream = new FileInputStream(new File("wallhaven-1k36vg.jpg"));

            //4.将要发送的文件写入outputStream 让他将其发送出去
            byte[] buffer = new byte[1024];
            int len;
            while( (len = fileInputStream.read(buffer)) != -1 ){
                outputStream.write(buffer,0,len);
            }

            //关闭数据输出
            socket.shutdownOutput();

            //5.接受来自服务器段的数据，并显示到控制台上
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream = socket.getInputStream();
            while ( (len = inputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());
            byteArrayOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
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

    //client                                                     server
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
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(9090);
            //2.调用accept（）表示接受来自客户端的socket
            socket = serverSocket.accept();
            //3.获取一个输入流，接受客服端发送的文件
            inputStream = socket.getInputStream();
            //4.获取FileOutputStream，指定要保存的文件
            fileOutputStream = new FileOutputStream("clientFile10.jpg");
            //5.inputStream接收客户端发送的文件，让fileOutputStream写入本地
            byte[] buffer = new byte[1024];
            int len;

            while ( (len = inputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }

            //6.客户端给与服务器段反馈
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("文件已接收。".getBytes(StandardCharsets.UTF_8));
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //7.关闭资源
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


