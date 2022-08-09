package homework.work7.fileDemo;

import java.io.*;
import java.util.*;


/**
 * 作业需求:
 * 1. File类的list功能递归遍历filedir
 * 2. 遍历文件使用文件过滤器获得目录中有几种不同的文件格式以及文件的个数
 * 结果存储到map集合中
 * {java:4,txt:2,doc:8}
 * 3.根据map 集合的 key 创建目录  例如java 目录 并把文件移动到对应的目录中
 * 复制(字节流进行文件复制)
 * 4. 定义一个方法  把map 集合中文件和文件记录数据写入到一个文件中 要求按照从高到低写入到文件
 * 对map 集合的value 进行排序
 * filestatus:
 * 文件类型   个数
 * java           8
 * doc           6
 */
@SuppressWarnings("all")
public class FileOperationDemo1 {

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
                } else if (file.isFile()) {
                    //文件数量加一
                    fileNum++;
                    String[] file_split = file.getName().split("\\.");
                    fileType.putIfAbsent(file_split[1], 0);
                    fileType.put(file_split[1], fileType.get(file_split[1]) + 1);
                    fileNames.add(file.getName());
                    filePaths.add(file.getPath());
                }
            }
        }
    }

    //创建对应类型的目录
    public void createDirectory(HashMap<String, Integer> fileType, String dest_filePath) {
        Iterator<String> iterator = fileType.keySet().iterator();
        while (iterator.hasNext()) {
            String directory = iterator.next();
            System.out.println(directory);
            File file = new File(dest_filePath + directory);
            if (!file.exists()) {
                boolean success = file.mkdirs();
                if (success)
                    System.out.println("成功创建多级目录" + dest_filePath + directory);
                else
                    System.out.println("创建失败，目录可能已经存在");
            }
        }
    }
    //将文件分类复制到目标分类目录下

    /**
     * 将
     *
     * @param fileType  文件类型
     * @param filePaths 文件相对路径
     * @param fileNames 文件名
     */
    public void copyFileToDest_directory(HashMap<String, Integer> fileType, List<String> filePaths, List<String> fileNames, String dest_filePath) {
        for (int i = 0; i < filePaths.size(); i++) {
            FileInputStream fis = null;//源文件路径,已经确定好了的
            FileOutputStream fos = null;
            InputStream is = null;
            OutputStream os = null;
            try {
                fis = new FileInputStream(new File(filePaths.get(i)));
                String[] filePathTemp = filePaths.get(i).split("\\.");
                String dest = dest_filePath + filePathTemp[1] + "//" + fileNames.get(i);
                System.out.println("dest = " + dest);
                fos = new FileOutputStream(new File(dest));//目的文件路径，不能确定的路径，需要判断文件类型再添加路径修饰

                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 用于排序
     *
     * @param fileType 记录文件类型的map集合
     * @return List集合对map集合进行排序后的
     */
    public List<Map.Entry<String, Integer>> sortFileMapRecode(HashMap<String, Integer> fileType) {
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(fileType.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> mapping : list) {
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
        return list;
    }

    /**
     * 将排序后的文件
     *
     * @param list
     * @param recodePath
     * @param recodeName
     */
    public void writeInfo(List<Map.Entry<String, Integer>> list, String recodePath, String recodeName) {
        FileOutputStream fos = null;
        File file = null;
        BufferedWriter bf = null;
        try {
            file = new File(recodePath);
            if (!file.exists()) {
                boolean success = file.mkdirs();
                if (success) {
                    System.out.println("成功创建记录目录");
                    file = new File(recodePath + "\\" + recodeName);
                    if (!file.exists()) {
                        boolean successCreate = file.createNewFile();
                        if (successCreate) {
                            System.out.println("成功创建记录文件");
                        } else {
                            System.out.println("创建记录文件失败，可能找不到指定的目录或记录");
                        }
                    }
                } else {
                    System.out.println("创建记录文件夹失败,原因:可能找不到指定路径的目录");
                }
            }

            bf = new BufferedWriter(new FileWriter(new File(recodePath + "\\recode.txt")));
            bf.write("文件状态\n文件类型\t\t\t数量");
            bf.newLine();
            for (Map.Entry<String, Integer> mapping : list) {
                bf.write(mapping.getKey() + "\t\t\t");
                if (mapping.getKey().toString().length() == 3) {
                    bf.write("\t");
                }
                System.out.println("mapping.getValue() = " + mapping.getValue());
                bf.write(mapping.getValue().toString());
                bf.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String source_filePath = "shixun//src//homework//work7//filedir";
        FileOperationDemo1 f = new FileOperationDemo1();
        f.iter_files(source_filePath);
        System.out.println("f.fileNum = " + f.fileNum);
        System.out.println("f.directoryNum = " + f.directoryNum);

        System.out.println("f.fileName.toArray().toString() = " + Arrays.toString(f.fileNames.toArray()));
        System.out.println("Arrays.toString(f.fileType.entrySet().toArray()) = " + Arrays.toString(f.fileType.entrySet().toArray()));
        System.out.println("Arrays.toString(f.filePaths.toArray()) = " + Arrays.toString(f.filePaths.toArray()));
        String dest_filePath = "shixun//src//homework//work7//dest_files//";
        String recodeFilePath = "shixun//src//homework//work7//recodeFile";
        String recodeName = "recode.txt";
//        f.createDirectory(f.fileType,dest_filePath);
//        f.copyFileToDest_directory(f.fileType, f.filePaths, f.fileNames, dest_filePath);


        List<Map.Entry<String, Integer>> list = f.sortFileMapRecode(f.fileType);
        System.out.println("list.toArray() = " + Arrays.toString(list.toArray()));
        f.writeInfo(list, recodeFilePath, recodeName);
    }


}
