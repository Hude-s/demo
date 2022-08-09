package demo1.day04.phone;

import java.util.Scanner;

public class PhoneManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneOperation phoneOperation = new PhoneOperation();
        String[] brands = {"华为", "小米", "IPhone", "摩托罗拉", "三星"};
        String[] phoneNames = {"k30", "k40", "m12", "12", "8"};
        double[] phonePrice = {4999, 2999, 3999, 5999, 6999};

        while (true) {
            System.out.println("========欢迎使用韶关学院手机信息管理系统======");
            System.out.println("1:自动录入数据");
            System.out.println("2: 查看数据");
            System.out.println("3: 价格排序");
            System.out.println("4: 退出系统");
            System.out.println("请输入操作功能编号:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    phoneOperation.autoInputData(brands, phoneNames, phonePrice);
                    break;
                case 2:
                    phoneOperation.showPhoneInfos();
                    break;
                case 3:
                    phoneOperation.sortPhoneByPrice();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }

    }
}
