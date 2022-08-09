package demo1.day04.phone1;
/*
 * 基于数组的手机信息管理系统
 * 1. 定义一个手机类  属性 品牌 名称  价格(int)
 * 2. 使用Scanner 类对象 循环输入 4个手机对象信息 并存储到数组中
 * 3. 定义方法  实现打印数组中手机信息  格式如下:
 *    [
 *     {品牌:华为,名称:Mate40,价格:6888},
 *     {},
 *     {},
 *     {}
 *    ]
 * 4. 对数组中手机价格 按照升序排列  并打印信息输出
 * */
public class TelPhone {
    private String brand;
    private double price;
    private String name;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "brand:'" + brand + '\'' +
                ", price:" + price +
                ", name:'" + name + '\'' +
                '}';
    }

    public TelPhone(String brand, double price, String name) {
        this.brand = brand;
        this.price = price;
        this.name = name;
    }

    public TelPhone() {
    }
}
