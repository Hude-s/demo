package homework.work8.thread1;
// 面包类  数据
public class Bread {
    private String breadColor; // 面包颜色
    private String breadType; // 面包的类型

    public Bread(String breadColor, String breadType) {
        this.breadColor = breadColor;
        this.breadType = breadType;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "breadColor='" + breadColor + '\'' +
                ", breadType='" + breadType + '\'' +
                '}';
    }
}
