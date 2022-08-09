package homework.work11;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class PicClient1 {

    /**
     * System.out.println("---------欢迎使用韶关学院控制台版本图片服务器(client)-------");
     * System.out.println("1.浏览服务器图片(显示图片名列表)");
     * System.out.println("2.上传图片到服务器");
     * System.out.println("3.下载图片到本地");
     * <p>
     * <p>
     * <p>
     * System.out.println("---------欢迎使用图片服务器后台管理系统(server)-------");
     * System.out.println("1.浏览服务器图片");
     * System.out.println("2.删除图片(执行删除功能前需要进行登录验证 输入口令 固定一个字符串)");
     */

    @Test
    public void client() {
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        ByteArrayOutputStream baos = null;


        try {
            //获取和服务器的连接
            InetAddress inetAddress = InetAddress.getByName("localhost");
            socket = new Socket(inetAddress, 8989);

            //一个通信？控制？

            //获取与服务器通信的输入输出流
            //优化——》写成工具类或方法？+配置文件？
            is = socket.getInputStream();
            os = socket.getOutputStream();

            //获取服务器所能进行操作的提示？接收服务端传来的操作提示
            byte[] buff = new byte[1024];
            int len;
            baos = new ByteArrayOutputStream();
            while ((len = is.read(buff)) != -1) {
                baos.write(buff, 0, len);
            }
            //输出服务器传来的信息
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos!=null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null) {
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

        try {
            //创建服务器开放的服务端口，并进行监听  ？问题个客户端连接过来的请求处理？下载文件请求的？多线程？
            serverSocket = new ServerSocket(8989);
            socket = serverSocket.accept();

            //获取向客户端通信的输入输出流对象
            is = socket.getInputStream();
            os = socket.getOutputStream();

            //向客户端提示服务器所能提供的服务
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("---------欢迎使用韶关学院控制台版本图片服务器(client)-------\n");
            stringBuilder.append("1.浏览服务器图片(显示图片名列表)\n");
            stringBuilder.append("2.上传图片到服务器\n");
            stringBuilder.append("3.下载图片到本地\n");


            //转换成数组
            byte[] notice = stringBuilder.toString().getBytes();

            //通过和客户端建立的通道写出信息到客户端
            os.write(notice);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket!=null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
