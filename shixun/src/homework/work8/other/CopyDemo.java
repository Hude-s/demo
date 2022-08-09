package homework.work8.other;

import java.io.*;


public class CopyDemo {


    /**
     * 需求
     * 		将工程目录下的小苹果.mp3复制到工程目录下小苹果Copy.mp3
     * 		使用4中方式复制
     * 			1.字节流一次复制一个字节
     * 			2.字节流一次复制一个字节数组
     * 			3.缓冲字节流一次复制一个字节
     * 			4.缓冲字节流一次复制一个字节数组
     */

    /**
     * 需求
     * 将 C:\abc 文件夹中的所有文件复制到 C:\test 文件夹
     * 分析
     * 1.定义一个File关联到对应的文件夹C:\abc
     * 2.listFiles列出里面的所有内容
     * 3.遍历每个File对象
     * 4.如果是文件夹,就不管
     * 5.如果是文件就复制
     * 来源:遍历到的File对象
     * 目的地: 目的地文件夹+文件名(C:\abc\1.jpg)
     */
    public static void main(String[] args) {
        CopyDemo copyDemo = new CopyDemo();
        copyDemo.fileTest1(copyDemo);

    }


    public void fileTest1(CopyDemo copyDemo) {
        //文件路径
        File file = new File("shixun//src//homework//work8//music");
        String source = new String("//踏山河.mp3");
        String destination1 = new String("//踏山河copy1.mp3");
        String destination2 = new String("//踏山河copy2.mp3");
        String destination3 = new String("//踏山河copy3.mp3");
        String destination4 = new String("//踏山河copy4.mp3");

        //在内存中创建文件输入输出字节流对象
//        long begin1 = System.currentTimeMillis();
//        copyDemo.fileCopy1(file, source, destination1);
//        long end1 = System.currentTimeMillis() - begin1;
//        System.out.println("耗时" + end1 / 1000 + "秒");


        long begin2 = System.currentTimeMillis();
        copyDemo.fileCopy2(file, source, destination2);
        long end2 = System.currentTimeMillis() - begin2;
        System.out.println("耗时" + end2 + "毫秒");

        long begin3 = System.currentTimeMillis();
        copyDemo.fileCopy3(file, source, destination3);
        long end3 = System.currentTimeMillis() - begin3;
        System.out.println("耗时" + end3 + "毫秒");


        long begin4 = System.currentTimeMillis();
        copyDemo.fileCopy4(file, source, destination4);
        long end4 = System.currentTimeMillis() - begin4;
        System.out.println("耗时" + end4 + "毫秒");
    }

    //1.字节流一次复制一个字节
    public void fileCopy1(File file, String fileSource, String destination) {
        InputStream is = null;
        OutputStream os = null;
        File file1 = new File(file.getPath() + fileSource);
        long fileLength = file1.length();
        try {
            is = new FileInputStream(file.getPath() + fileSource);
            os = new FileOutputStream(file.getPath() + destination);
//            for (int i = 0; i < fileLength; i++) {
//                int data = is.read();
//                os.write(data);
//            }
            int data;
            while ((data = is.read()) != -1) {
                os.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    //2.字节流一次复制一个字节数组
    public void fileCopy2(File file, String fileSource, String destination) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(file.getPath() + fileSource.toString());
            os = new FileOutputStream(file.getPath() + destination);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fileCopy3(File file, String fileSource, String destination) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File file1 = new File(file + fileSource);
        long fileLength = file1.length();

        try {
            bis = new BufferedInputStream(new FileInputStream(file + fileSource));
            bos = new BufferedOutputStream(new FileOutputStream(file + destination));
//            for (long i = 0; i < fileLength; i++) {
//                int data = bis.read();
//                bos.write(data);
//            }
            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    //4.缓冲字节流一次复制一个字节数组
    public void fileCopy4(File file, String fileSource, String destination) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file.getPath() + fileSource.toString()));
            bos = new BufferedOutputStream(new FileOutputStream(file.getPath() + destination));

            int len;
            byte[] buffer = new byte[1024];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
