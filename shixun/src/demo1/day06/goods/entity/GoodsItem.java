package demo1.day06.goods.entity;

// 商品实体类  封装商品数据信息
public class GoodsItem {
    // 品名
    private String name;

    // 货号
    private String id;

    // 单价
    private double price;

    // 库存
    private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "" +
                "\t\t" + name +
                "\t\t\t" + id +
                "\t" + price +
                "\t\t" + count +
                "\t\t\t";
    }

    public GoodsItem() {
    }

    public GoodsItem(String name, String id, double price, int count) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.count = count;
    }

}
