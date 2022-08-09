package homework02.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final int PORT = 31920;
    public static InetAddress SERVER_IP;

    public static final int PICTURES = 1;
    public static final int UPLOAD = 2;
    public static final int DOWNLOAD = 3;
    public static final int EXIT = 4;

    // message -> code
    public static final int SUCCEED = 0;
    public static final int FAILED = -1;


//    public static final String LOCAL_SAVE_PATH = "M:\\03_study\\01_computer\\03_scene\\day19\\src\\pic_client\\";
    public static final String LOCAL_SAVE_PATH = "E:\\WorkSpace\\idea_work\\demo\\tcp\\pic_client";
//    public static final String LOCAL_SAVE_PATH = "pic_cli\\";

//    public static final String SERVER_SAVE_PATH = "M:\\03_study\\01_computer\\03_scene\\day19\\src\\pic_server\\";
    public static final String SERVER_SAVE_PATH = "E:\\WorkSpace\\idea_work\\demo\\tcp\\pic_serve";
//    public static final String SERVER_SAVE_PATH = "pic_serve\\";

//    public static final String SERVER_PIC_PATH = "M:\\03_study\\01_computer\\03_scene\\day19\\src\\pic_server\\";
    public static final String SERVER_PIC_PATH = "E:\\WorkSpace\\idea_work\\demo\\tcp\\pic_server";
//    public static final String SERVER_PIC_PATH = "pic_serve\\";

    static {
        try {
            SERVER_IP = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeStream(InputStream inputStream, OutputStream outputStream) {
        try {
            if (inputStream != null) inputStream.close();
            if (outputStream != null) outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void closeSocket(Socket socket) {

        try {
            if (!socket.isClosed()) socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean hasPic(String picPath) {
        if (picPath == null || "".equals(picPath)) return false;

        File file = new File(picPath);
        if ( !file.exists() || ! file.isFile()) return false;

        return true;
    }

    public static List<String> getPicList(String path){
        File file = new File(path);
        File[] files = file.listFiles((dir, name) -> {
            String suffix = name.substring(name.lastIndexOf("."));
            if (".png".equals(suffix) || ".jpg".equals(suffix) || ".jepg".equals(suffix)) {
                return true;
            }
            return false;});

        ArrayList<String> list = new ArrayList<>();
        for (File item : files) {
            list.add(item.getName());
        }
        return list;
    }

    /**
     * 处理照片重复问题
     * 再名字后面标 1，2，3序号区别处理
     * @param picName
     * @return
     */
    public static File repeatedFiles(String dir,String picName){
        File savePath = new File(dir + picName);
        File parentFile = savePath.getParentFile();
        if (!parentFile.exists()){
            parentFile.mkdirs();
        }

        int salt = 1;
        while (savePath.isFile()) {
            String name = savePath.getName();
            int index = picName.lastIndexOf(".");
            String subName = picName.substring(0,index);
            String suffix = picName.substring(index) ;

            savePath = new File(dir + subName + salt + suffix);
            salt++;
        }

        return savePath;
    }


}
