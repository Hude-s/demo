package demo1.day04.phone2;

import java.util.Random;

// 手机操作类
public class PhoneArrayOperation {
    // 定义一个数组
    private TelPhone[] phoneArray;

    public TelPhone[] getPhoneArray() {
        return phoneArray;
    }

    public void setPhoneArray(TelPhone[] phoneArray) {
        this.phoneArray = phoneArray;
    }

    public void autoInputDatas() {
        // 构架基础数据  品牌  名称 价格
        String[] brandsArray = {"iphone", "sanxing", "huawei", "xiaomi", "moluoluola", "nuojiya"};
        String[] phoneName = {"嘻嘻", "呵呵", "嘿嘿", "吼吼", "哈哈"};
        double[] phonePrice = {1.1, 2.1, 3.2, 4.3, 5.4};

        for (int i = 0; i < phoneArray.length; i++) {
            TelPhone phone = new TelPhone();
            Random random = new Random();
            phone.setBrand(brandsArray[random.nextInt(phoneArray.length)]);
            phone.setName(phoneName[random.nextInt(phoneArray.length)]);
            phone.setPrice(phonePrice[random.nextInt(phoneArray.length)]);
            phoneArray[i] = phone;
        }
        System.out.println("录入数据成功....");
        for (TelPhone telPhone : phoneArray) {
            System.out.println(telPhone);
        }
    }

    public void showPhoneInfos() {
        System.out.println("开始打印数据.....");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append("\r\n");


        for (int i = 0; i < phoneArray.length; i++) {
            if (phoneArray[i] == null) {
                stringBuilder.append("{}").append(",").append("\r\n");
                if (i == phoneArray.length - 1) {
                    stringBuilder.append("]").append("\r\n");
                }
            } else {
                stringBuilder.append(phoneArray[i]).append(",").append("\r\n");
                if (i == phoneArray.length - 1) {
                    stringBuilder.append("]").append("\r\n");
                }
            }
        }
        System.out.print(stringBuilder.toString());
    }

    public void sortPhoneByPrice() {
        System.out.println("排序结果如下");
        for (int i = 0; i < phoneArray.length; i++) {
            if (phoneArray[i] == null) {
                System.out.println("没有数据，排序无意义");
                return;
            } else {
                for (int j = i; j < phoneArray.length; j++) {
                    if (phoneArray[i].getPrice() > phoneArray[j].getPrice()) {
                        TelPhone phone = phoneArray[j];
                        phoneArray[j] = phoneArray[i];
                        phoneArray[i] = phone;
                    }
                }
            }
        }
        showPhoneInfos();
    }

    public void sortPhoneByPrice1() {
        System.out.println("排序结果如下");
        for (int i = 0; i < phoneArray.length; i++) {
            if (phoneArray[i] == null) {
                System.out.println("没有数据，排序无意义");
                return;
            } else {
                for (int j = i; j < phoneArray.length; j++) {
                    if (phoneArray[i].getPrice() > phoneArray[j].getPrice()) {
                        TelPhone phone = phoneArray[j];
                        phoneArray[j] = phoneArray[i];
                        phoneArray[i] = phone;
                    }
                }
            }
        }
        showPhoneInfos();
    }

}
