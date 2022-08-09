package demo.serverSocket;

import java.io.*;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Socket_Client extends Thread {
    private Socket socket_client;

    private boolean connectState = false;
    private OutputStream outputStream;
    private DataOutputStream dataOutputStream;
    private InputStream inputStream;
    private DataInputStream dataInputStream;

    //客户端使用Socket连接服务器端的主机步骤：
    //1、创建Socket对象，绑定要连接的主机地址和端口号
    public Socket_Client(String host, int port) throws IOException {
        socket_client = new Socket(host, port);
        if (socket_client != null) {
            connectState = true;
            System.out.println("远程连接到的主机地址：" + socket_client.getRemoteSocketAddress());
        } else {
            System.out.println("未连接到主机");
        }

    }

    public boolean getConnectState() {
        return connectState;
    }

    public void run(String writeToServer) {
        try {
            //创建输出流,用于向服务器写数据
            outputStream = socket_client.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);

            Scanner sc = new Scanner(System.in);
            writeToServer = sc.next();
            dataOutputStream.writeUTF("client:" + writeToServer);

            //创建输入流，用于读取服务器写回来的数据
            inputStream = socket_client.getInputStream();
            dataInputStream = new DataInputStream(inputStream);

            String readFromServer = dataInputStream.readUTF();
            System.out.println("server:" + readFromServer);
        } catch (SocketTimeoutException e) {
            System.out.println(e);
            System.out.println("连接超时！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket_client != null) {
                try {

                    socket_client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        Socket_Client socket_client = new Socket_Client("127.0.0.1", 6066);
        if (socket_client.getConnectState()) {
            Scanner scanner = new Scanner(System.in);
            String clientToServer = scanner.next();
            if (clientToServer != null) {
                socket_client.run(clientToServer);
            }
        }else {
            System.out.println("=====未连接到主机=======");
        }

    }

}
