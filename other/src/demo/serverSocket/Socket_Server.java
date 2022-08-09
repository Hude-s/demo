package demo.serverSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Socket_Server extends Thread {
    private ServerSocket serverSocket;
    private Socket socket;

    private OutputStream outputStream;
    private DataOutputStream dataOutputStream;
    private InputStream inputStream;
    private DataInputStream dataInputStream;

    //设置应用的开放端口
    public Socket_Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        while (true) {
            //创建与客户机进行交互的Socket套接字，服务端的套接字不能直接new出来，需要调用ServerSocket的对象 获取
            try {
                //接受连接请求
                socket = serverSocket.accept();
                System.out.println("输出连接信息");
                System.out.println("socket.getRemoteSocketAddress() = " + socket.getRemoteSocketAddress());
                System.out.println("socket.getLocalSocketAddress() = " + socket.getLocalSocketAddress());
                System.out.println("socket.getPort() = " + socket.getPort());
                System.out.println("socket.getLocalPort() = " + socket.getLocalPort());

                //创建写入写出流,服务器和客户机之间通过套接字的输入输出流进行通信
                inputStream = socket.getInputStream();
                dataInputStream = new DataInputStream(inputStream);

                outputStream = socket.getOutputStream();
                dataOutputStream = new DataOutputStream(outputStream);

                Scanner sc = new Scanner(System.in);
                String writeToClient = sc.next();

                dataOutputStream.writeUTF("Server:" + writeToClient);

                String readFromClient = dataInputStream.readUTF();
                System.out.println("Client:" + readFromClient);

            } catch (SocketTimeoutException e) {
                System.out.println("连接超时！");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
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
    }

    public static void main(String[] args) throws IOException {
        Socket_Server socket_server = new Socket_Server(6066);
        socket_server.run();
    }
}
