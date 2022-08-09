//package homework.work11;
//
//import org.junit.Test;
//
//import java.io.*;
//import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class PicClient {
//
//    /**
//     * 需求：
//     * System.out.println("---------欢迎使用韶关学院控制台版本图片服务器(client)-------");
//     * System.out.println("1.浏览服务器图片(显示图片名列表)");
//     * System.out.println("2.上传图片到服务器");
//     * System.out.println("3.下载图片到本地");
//     * <p>
//     * <p>
//     * <p>
//     * System.out.println("---------欢迎使用图片服务器后台管理系统(server)-------");
//     * System.out.println("1.浏览服务器图片");
//     * System.out.println("2.删除图片(执行删除功能前需要进行登录验证 输入口令 固定一个字符串)");
//     */
//
//    @Test
//    public void client() {
//
//
//        //获取和服务器的连接
//        InetAddress inetAddress = InetAddress.getByName("localhost");
//        Socket socket = new Socket(inetAddress, 8989);
//
//        //一个通信？控制？
//
//        //获取与服务器通信的输入输出流
//        //优化——》写成工具类或方法？+配置文件？
//        InputStream is = socket.getInputStream();
//        OutputStream os = socket.getOutputStream();
//
//        //获取服务器所能进行操作的提示？接收服务端传来的操作提示
//        byte[] buff = new byte[1024];
//        int len;
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        while ((len = is.read(buff)) != -1) {
//            baos.write(buff, 0, len);
//        }
//        //输出服务器传来的信息
//        System.out.println(baos.toString());
//
//        //客户端需要向服务器输出的操作?  ---》需要循环的读取客户端的操作
//        /**
//         * 客户端向服务器端的输入
//         *   *一个是输入操作指令，如（浏览，上传，下载）？
//         *   *一个是上传文件选择的路径，？
//         *   *一个是下载文件的选项，或者输入的路径？
//         */
//
//
//        /**
//         * 1、连接服务器 （循环??）否？？通过socket与服务器建立连接后能获取到服务器和客户端的输入输出流对象，
//         *    通过向输入输出流对象写入写出就可完成数据传输，关键是没有关闭连接
//         *    应当把  -连接  -服务器输出   -向服务器输入   --关闭流 等操作分开进行？？？
//         *
//         * 2、获取服务器传输来的操提示 （循环的？？？）多线程？？？？
//         * 3、向服务器输入操作选择（循环的）多线程？？？
//         *   *
//         */
//
//        Scanner scanner = new Scanner(System.in);
//        //需要读取输入的操作-》阻塞的方法？？？
//        String operation = scanner.next();
//        //向服务器写出
//        os.write(operation);
//
//
//
//        //关闭流
//        os.close();
//        is.close();
//        baos.close();
//        socket.close();
//
//    }
//
//    @Test
//    public void server() {
//
//        //创建服务器开放的服务端口，并进行监听  ？问题个客户端连接过来的请求处理？下载文件请求的？多线程？
//        ServerSocket serverSocket = new ServerSocket(8989);
//        Socket socket = serverSocket.accept();
//
//        //获取向客户端通信的输入输出流对象
//        InputStream is = socket.getInputStream();
//        OutputStream os = socket.getOutputStream();
//
//        //向客户端提示服务器所能提供的服务
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("\n---------欢迎使用韶关学院控制台版本图片服务器(client)-------\n");
//        stringBuilder.append("1.浏览服务器图片(显示图片名列表)\n");
//        stringBuilder.append("2.上传图片到服务器\n");
//        stringBuilder.append("3.下载图片到本地\n");
//
//        //转换成数组
//        byte[] notice = stringBuilder.toString().getBytes();
//        ByteArrayInputStream bis = new ByteArrayInputStream(notice);
//        //通过和客户端建立的通道写出信息到客户端
//        os.write(notice);
//
//        //读取客户端传来的操作要求，要求===》循环的读取监听，（多线程？？）
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        byte[] buf = new byte[1024];
//        int len;
//        while ((len = is.read(buf)) != -1) {
//            baos.write(buf, 0, len);
//        }
//
//
//        //关闭流
//        os.close();
//        is.close();
//        baos.close();
//        socket.close();
//        serverSocket.close();
//    }
//}
