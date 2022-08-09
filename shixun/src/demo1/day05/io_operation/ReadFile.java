package demo1.day05.io_operation;

import java.io.*;
import java.util.Scanner;

public class ReadFile {
    public void readFile01() {
        String filePath = "regular_expression\\src\\demo1\\day05\\2.txt";
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        int readData = 0;
        try {
            fileInputStream = new FileInputStream(file);
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readFile02() {
        String filePath = "regular_expression\\src\\demo1.day05\\3.txt";
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        byte[] buf = new byte[8];
        int readLen = 0;
        try {
            fileInputStream = new FileInputStream(file);
            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fileOutput01() {
        String filePath = "regular_expression\\src\\demo1\\day05\\3.txt";
        File file = new File(filePath);
        FileOutputStream fileOutputStream = null;
        String writeContent = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            Scanner scanner = new Scanner(System.in);
            System.out.println("等待输入");
            writeContent = scanner.next();
            fileOutputStream.write(writeContent.getBytes());
            System.out.println("完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fileCopy() {
        BufferedWriter bufferedWriter = null;
        String filePath = "";
        String filePath1 = "";
        File file = new File(filePath);
        File file1 = new File(filePath1);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] buf = new byte[30];
        try {
            fileInputStream = new FileInputStream(file);
            while ((fileInputStream.read(buf) != -1)) {
                System.out.println(new String(buf, 0, buf.length));
            }
            fileOutputStream = new FileOutputStream(file1, true);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
//        readFile.readFile02();
//        readFile.fileOutput01();

        readFile.readFile01();
    }

}
