package demo3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BrowsePic {

    int fileNum = 0;
    int directoryNum = 0;
    HashMap<String, Integer> fileType = new HashMap<>();
    List<String> fileNames = new ArrayList<>();
    List<String> filePaths = new ArrayList<>();

    // 1. File类的list功能递归遍历filedir
    public void iter_files(String filePath) {
        File cur_directory = new File(filePath);
        File[] fileList = cur_directory.listFiles();
        if (fileList != null) {
            for (File file : fileList) {
                //需要递归遍历目录？？？？
                if (file.isDirectory()) {
                    //目录数量加一
                    directoryNum++;
                    iter_files(file.getPath());
//                    System.out.println("file.getPath() = " + file.getPath());
                } else if (file.isFile()) {
                    //文件数量加一
                    fileNum++;
//                    System.out.println("file.getPath() = " + file.getPath());
//                    System.out.println("file.getName() = " + file.getName());
                    String[] file_split = file.getName().split("\\.");
//                    System.out.println(file_split[1]);

//                    if (fileType.get(file_split[1]) == null) {
//                        fileType.put(file_split[1], 0);
//                    }
                    fileType.putIfAbsent(file_split[1], 0);
                    fileType.put(file_split[1], fileType.get(file_split[1]) + 1);
                    fileNames.add(file.getName());
                    filePaths.add(file.getPath());

                }
            }
        }
    }

    public static void main(String[] args) {
        String source_filePath = "shixun//src//demo3//pic_server";
        BrowsePic pic = new BrowsePic();
        pic.iter_files(source_filePath);
        System.out.println(Arrays.toString(pic.fileNames.toArray()));
    }

}
