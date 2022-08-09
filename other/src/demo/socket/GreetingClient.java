package demo.socket;

import java.io.*;
import java.net.Socket;

//客户端程序
public class GreetingClient {
    public static void main(String[] args) {
        //定义变量存储主机名称和端口号
        String serverName = "127.0.0.1";
        int port = Integer.parseInt("6066");
        try {
            System.out.println("连接到主机：" + serverName + "端口号：" + port);

            //创建套接字对象，绑定主机名和端口
            Socket client = new Socket(serverName, port);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());

            //定义输出流引用，从套接字对象获取（套接字的）输出流对象
            OutputStream outToServer = client.getOutputStream();
            //创建数据输出流对象，
            DataOutputStream out = new DataOutputStream(outToServer);

            //使用数据输出流对象写字符串和本机地址
            out.writeUTF("Hello from" + client.getLocalAddress());

            //定义输入流引用，从套接字对象中获取（套接字的）输入流对象
            InputStream inFromServer = client.getInputStream();

            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应：" + in.readUTF());
            //关闭套接字连接
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
