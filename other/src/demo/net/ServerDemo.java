package demo.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo extends Thread {
    //
    ServerSocket serverSocket = null;
    Socket socket = null;

    public ServerDemo(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println(serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                socket = serverSocket.accept();
                System.out.println(socket);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void close() {
        if (socket != null) {
            try {
                socket.close();
                System.out.println("用于服务器和客户端交互的套接字正在关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (serverSocket != null) {
            try {
                serverSocket.close();
                System.out.println("服务器套接字正在关闭");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //加上手动运行和关闭
        ServerDemo serverDemo = null;

        System.out.println("请选择开启和关闭连接服务");
        System.out.println("1,开启服务");
        System.out.println("2,关闭服务");
        int choose = 0;
        Scanner scanner = new Scanner(System.in);
        choose = scanner.nextInt();
        while (choose != 2) {
            switch (choose) {
                case 1:
                    serverDemo = new ServerDemo(9999);
                    serverDemo.run();
                    System.out.println("服务已经开启");
                    break;
                case 2:
                    //关闭服务
                    System.out.println("准备关闭服务器");
                    serverDemo.close();
                    System.out.println("服务已经关闭");
                    break;
            }
            choose = scanner.nextInt();
            System.out.println("===" + choose);
        }
        System.out.println("已经退出");
    }
}
