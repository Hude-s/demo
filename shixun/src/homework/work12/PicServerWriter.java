package homework.work12;

import java.io.IOException;

public class PicServerWriter extends PicServer implements Runnable {

    private PicServer picServer;

    public PicServerWriter(PicServer picServer) {
        this.picServer = picServer;
    }

    /**
     * 向客户端写出提示操作以及列出文件的
     */
    @Override
    public void run() {
        while (true) {
            writer();
        }
    }
    public void writer(){
        //向客户端提示服务器所能提供的服务
        String str = "---------欢迎使用韶关学院控制台版本图片服务器(client)-------\n" +
                "1.浏览服务器图片(显示图片名列表)\n" +
                "2.上传图片到服务器\n" +
                "3.下载图片到本地\n";

        //转换成数组
        byte[] notice = str.getBytes();

        System.out.println("服务器写操作启动  " + Thread.currentThread().getName());
        //通过和客户端建立的通道写出信息到客户端
        try {
            picServer.os.write(notice);
        } catch (IOException e) {
            e.printStackTrace();
        }
        synchronized (picServer) {
            picServer.notify();
        }
    }
}
