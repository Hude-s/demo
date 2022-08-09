package tcpdemo.demo1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest5 {
    @Test
    public void client() {

        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 9998);

            is = socket.getInputStream();
            os = socket.getOutputStream();

            os.write("abcdef".getBytes());
            //关闭输出
            socket.shutdownOutput();

            //字节数组输出流
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[20];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null)
                    baos.close();
                if (is != null)
                    is.close();
                if (os != null)
                    os.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //转换成写字母输出
        //System.out.println(baos.toString().toUpperCase());

    }

    @Test
    public void server() {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        ByteArrayOutputStream baos = null;
        try {
            serverSocket = new ServerSocket(9998);
            socket = serverSocket.accept();

            is = socket.getInputStream();
            os = socket.getOutputStream();

            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len;
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println("在服务器转换大写" + baos.toString().toUpperCase());

            os.write(baos.toString().toUpperCase().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
                if (baos != null)
                    baos.close();
                if (is != null)
                    is.close();
                if (socket != null)
                    socket.close();
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        byte[] buffer1 = new byte[20];
//        int len1;
//        while ((len1 =os.write(buffer1))!=-1){
//
//        }
    }
}
