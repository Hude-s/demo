package demo1.day06.goods_demo.ui;



import demo1.day06.goods_demo.entity.GoodsItem;
import demo1.day06.goods_demo.entity.User;
import demo1.day06.goods_demo.utils.GoodsItemCartOperation;
import demo1.day06.goods_demo.utils.UserOperation;

import java.util.ArrayList;
import java.util.Scanner;

// 程序入口
public class GoodsItemMainApp {
    public static void main(String[] args) throws Exception {
        // 定义一个集合存放库存的商品
        // JDK1.7的特性
        ArrayList<GoodsItem> goodsItem = new ArrayList<>();
        ArrayList<User> user = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        ArrayList<GoodsItem> buyGoodsItem = null; // 表示购买好的商品(不要放循环里面)
        GoodsItemCartOperation goodsItemCartOperation = new GoodsItemCartOperation(goodsItem);
        UserOperation userOperation = new UserOperation(user);
        goodsItem = goodsItemCartOperation.initGoods();

//        注册登录界面
        userOperation.register();

        // 主干逻辑
        while (true) { // 4.	循环让用户输入
            // 1.	输出固定字符串

            System.out.println("1: 查看商品");
            System.out.println("2: 购买商品");
            System.out.println("3: 打印小票");
            System.out.println("4: 退出");
            System.out.println("=======请输入操作功能编号:=======");

            // 2.	让用户键盘录入
            int operation = sc.nextInt();
            sc.nextLine();
            // 3.	根据用户输入的数字做不同的操作
            switch (operation) {
                case 1:
                    goodsItemCartOperation.showGoodsItem(goodsItem);
                    break;
                case 2:
                    buyGoodsItem = goodsItemCartOperation.buyGoodsItem();
                    break;
                case 3:
                    goodsItemCartOperation.print(buyGoodsItem);
                    break;
                case 4:
                    System.out.println("欢迎下次再来...");
                    goodsItemCartOperation.writeGoods();
                    System.exit(0);
                    break;

                default:
                    System.out.println("您的输入有误,请重新输入...");
                    break;
            }
        }
    }
}
