package homework.work10;

import org.junit.Test;

import javax.naming.ldap.SortKey;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author 北渊
 * @version 1.0
 * @description: TODO 实现TCP的网络编程
 *                      //例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
 * @date 2022/7/2 13:45
 */
public class TCPTest1 {

    @Test
    public void client(){

        Socket socket = null;
        OutputStream outputStream = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress,8899);

            //2.获取一个输出流，用于输出数据
            outputStream = socket.getOutputStream();

            //3.写出数据
            outputStream.write("你好，我是客户端。".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源的关闭
            if ( outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if ( socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }

    }


    @Test
    public void server(){

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //1.创建服务器端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2.调用accept（）表示接受来自客户端的socket
            socket = serverSocket.accept();
            //3.获取一个输入流
            inputStream = socket.getInputStream();

            //不建议这样写，可能有乱码
//        byte[] buffer = new byte[1024];
//        int len;
//        while( (len = inputStream.read(buffer))!= -1){
//            String str = new String(buffer,0,len);
//            System.out.print(str);
//        }
            //4.读取输入流中的数据
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len;
            while( ( len = inputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }

            System.out.println(byteArrayOutputStream.toString());
            System.out.println("收到了来自：" + socket.getInetAddress().getHostAddress() + " 的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            if (byteArrayOutputStream !=null) {
                try {
                    byteArrayOutputStream.close();
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
