package demo.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo extends Thread {
    private Socket socket = null;

    public ClientDemo(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            System.out.println(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

    }

    public static void main(String[] args) {
//        ClientDemo clientDemo = new ClientDemo("127.0.0.1", 8888);


        //做一个循环输入
//        Scanner sc = new Scanner(System.in);
//        StringBuilder s = new StringBuilder();
//        String next = sc.next();
//        while (!next.equals("end")) {
//            s.append(next);
//            System.out.println(s);
//            System.out.println("next:" + next);
//            next = sc.next();
//        }

        ClientDemo clientDemo = null;
        //做一个循环连接
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        String rep = scanner.next();
        while (!rep.equals("end")) {
//            clientDemo = new ClientDemo("112.74.114.173", 9999);
            clientDemo = new ClientDemo("127.0.0.1", 9999);
            rep = scanner.next();
        }

    }
}
