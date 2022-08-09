package homework.work8.thread1;
// 桌子  用于放置面包
public class Desk {

    // 定义一个bool变量 标记桌子上有没有面包
    public static boolean hasBrad;

    private Bread bread;

    // 放面包
    public void  putBread(Bread bread){
        this.bread=bread;
    }
    // 取面包

    public Bread takeBread(){
        return bread;
    }
}
