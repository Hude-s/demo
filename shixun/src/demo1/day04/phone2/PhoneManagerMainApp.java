package demo1.day04.phone2;

import java.util.Scanner;

public class PhoneManagerMainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneArrayOperation phoneArrayOperation = new PhoneArrayOperation();
        TelPhone[] phoneArray = new TelPhone[4];
        phoneArrayOperation.setPhoneArray(phoneArray);


        while (true) {
            System.out.println("=========欢迎使用韶关学院手机信息管理系统====================");
            System.out.println("1: 自动录入数据");
            System.out.println("2: 查看数据");
            System.out.println("3: 价格排序");
            System.out.println("4: 退出系统");
            System.out.println("请输入操作功能编号:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
//                    phoneArrayOperation.setPhoneArray(phoneArray);
                    phoneArrayOperation.autoInputDatas();
                    break;
                case 2:
                    phoneArrayOperation.showPhoneInfos();
                    break;
                case 3:
                    phoneArrayOperation.sortPhoneByPrice();
                    break;
                case 4:
                    // 关机  关闭虚拟机
                    System.exit(0);
                    break;
            }
        }
    }
}
