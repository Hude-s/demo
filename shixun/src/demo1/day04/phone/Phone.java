package demo1.day04.phone;

public class Phone {
    private String brand;
    private String name;
    private double price;

    public Phone() {
    }

    @Override
    public String toString() {
        return "{" +
                "brand:'" + brand + '\'' +
                ", name:'" + name + '\'' +
                ", price:" + price +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Phone(String brand, String name, double price) {
        this.brand = brand;
        this.name = name;
        this.price = price;
    }
}
