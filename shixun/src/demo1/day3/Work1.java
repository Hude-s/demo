package demo1.day3;

import java.util.*;

public class Work1 {
    public static void main(String[] args) {
        Work1 w = new Work1();
        w.initPhone();
    }

    //创建手机类的数据结构
    static class Phone {
        //手机属性
        private String brand;//品牌
        private String name;//名称
        private double price;//价格


        @Override
        public String toString() {
            return "Phone{" +
                    "brand='" + brand + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        public Phone() {
        }

        public Phone(String brand, String name, double price) {
            this.brand = brand;
            this.name = name;
            this.price = price;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    //初始化数据-输入
    public ArrayList<Phone> initPhone() {

        Scanner sc = new Scanner(System.in);

        ArrayList<Phone> phoneArrayList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Phone phone = new Phone();
            System.out.println("===========》输入第" + (i + 1) + "对象的个数据《==============");
            System.out.println("请输入手机品牌：");
            phone.setBrand(sc.next());
            System.out.println("请输入手机名称：");
            phone.setName(sc.next());
            System.out.println("请输入手机价格：");
            phone.setPrice(sc.nextDouble());
            System.out.println("------------------------------------------------");
            phoneArrayList.add(phone);
        }
        priceAscendingOrder(phoneArrayList);
        print_phone(phoneArrayList);
        return phoneArrayList;
    }

    //打印输出
    public void print_phone(ArrayList<Phone> phoneArrayList) {
        if (phoneArrayList == null || phoneArrayList.size() == 0) {
            System.out.println("没有数据");
        }
        for (Phone phone : phoneArrayList) {
            System.out.println(phone);
        }
    }

    //按价格进行排序处理,价格升序排列
    public ArrayList<Phone> priceAscendingOrder(ArrayList<Phone> phoneArrayList) {
        if (phoneArrayList == null || phoneArrayList.size() == 0) {
            return null;
        }

        Collections.sort(phoneArrayList, new Comparator<Phone>() {
            @Override
            public int compare(Phone o1, Phone o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        return null;
    }


    //格式化处理,是数据变成json格式的数据，输出*
    public void print_phone_require(ArrayList<Phone> phoneArrayList) {
        if (phoneArrayList == null || phoneArrayList.size() == 0) {
            return;
        }


    }

}
