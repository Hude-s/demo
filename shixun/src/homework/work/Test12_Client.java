package homework.work;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 通过键盘录入发送消息给服务器，直到输入exit后停止发送
 * 多线程发送和接收
 * */
public class Test12_Client {
    public static void main(String[] args) throws Exception{
        while(true){
            Socket socket=new Socket(InetAddress.getLocalHost(),8888);
            new Thread(){
                public void run(){
                    Scanner sc = new Scanner(System.in);
                    try {

                        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream ps=new PrintStream(socket.getOutputStream());
                        ps.println(sc.nextLine());
                        String server_msg=br.readLine();
                        ps.flush();
                        System.out.println(server_msg+"---来自服务器");
                        if(null==server_msg){
                            socket.close();
                            System.exit(0);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
            //socket.close();
        }
    }
}