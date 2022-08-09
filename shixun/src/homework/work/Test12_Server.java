package homework.work;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/***
 *  通过客户端发送的exit来结束通信
 *  多线程接收和发送
 *
 *  按行输出输出和按行读取readLine()和println()配合使用，
 *  尤其，println后一定要使用flush将缓冲区内容刷新出去
 *
 * */
public class Test12_Server {
    public static void main(String[] args) throws Exception{
        ServerSocket server=new ServerSocket(8888);
        while(true){
            Socket socket = server.accept();
            new Thread(){
                public void run(){
                    Scanner sc = new Scanner(System.in);
                    try {
                        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream ps=new PrintStream(socket.getOutputStream());

                        String client_msg=br.readLine();
                        System.out.println(client_msg+"---来自客户端");
                        if("exit".equals(client_msg)){
                            socket.close();
                            System.exit(0);
                        }
                        ps.println(sc.nextLine());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            //socket.close();
        }

    }
}