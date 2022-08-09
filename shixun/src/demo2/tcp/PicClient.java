package demo2.tcp;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PicClient {

    Socket socket = null;
    InetAddress inetAddress = null;
    InputStream is = null;
    OutputStream os = null;
    ByteArrayInputStream bis = null;
    ByteArrayOutputStream bos = null;

    //连接到服务端
    public void getConnect() throws IOException {
        if (socket == null) {
            inetAddress = InetAddress.getByName("localhost");
            socket = new Socket(inetAddress, 9999);
        }
    }

    //获取socket输入输出流
    public void getIO() throws IOException {
        is = socket.getInputStream();
        os = socket.getOutputStream();
    }

    //读取
    public void reader() throws IOException {
        writer();
        int len;
        byte[] buff = new byte[1024];
        bos = new ByteArrayOutputStream();
        while ((len = is.read(buff)) != -1) {
            bos.write(buff, 0, len);
        }
        System.out.println(bos.toString());
    }

    public void writer() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            try {
                os.write(next.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //关闭socket-IO
    public void closeIO() throws IOException {
        if (is != null) {
            is.close();
        }
        if (os != null) {
            os.close();
        }
    }

    //关闭二进制流
    public void closeBinaryIO() throws IOException {
        if (bos != null) {
            bos.close();
        }
        if (bis != null) {
            bis.close();
        }
    }

    public void operation() throws IOException {
        getConnect();
        getIO();
        reader();
        closeBinaryIO();
        closeIO();

    }


}
