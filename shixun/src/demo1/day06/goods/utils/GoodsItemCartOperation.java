package demo1.day06.goods.utils;

import demo1.day06.goods.entity.GoodsItem;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 购物车操作类
/*
 * 1. 初始化商品  打印商品
 * 2. 加入商品到购物车
 * 3. 打印购物车商品数据
 * */
public class GoodsItemCartOperation {
    // 定义一个商品集合类对象
    private ArrayList<GoodsItem> goodsItem;

    public GoodsItemCartOperation() {
    }

    public GoodsItemCartOperation(ArrayList<GoodsItem> goodsItem) {
        this.goodsItem = goodsItem;
    }


    public void showGoodsItem() {
        System.out.println("\n===========================商品列表=============================");
        System.out.println("||\t\t\t商品名称\t\t商品编号\t\t商品单价\t\t库存\t\t\t ||");
        for (GoodsItem good : goodsItem) {
            System.out.println("|| \t" + good + " ||");
        }
        System.out.println("===============================================================\n\n");
    }

    // 购买商品方法
    public ArrayList<GoodsItem> buyGoodsItem(ArrayList<GoodsItem> goodsItem) {
        ArrayList<GoodsItem> goodsItemCartList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String choose;
        boolean flag = false;
        System.out.println("================您当前的操作页面为选购商品页面，退出请输入：-1 =================");
        System.out.println("请输入您要购买的商品的编号");
        while (true) {
            choose = scanner.next();
            if (choose.equals("-1")) {
                System.out.println("您退出了选购");
                break;
            }
            System.out.println("请输入要购买商品的id(-1表示结束购买):");
            for (GoodsItem item : goodsItem) {
                if (choose.equals(item.getId())) {
                    System.out.println("您要的商品找到了");
                    flag = true;
                    System.out.println("您选择的商品是：" + item.getName() + "\t\t该商品的单价是" + item.getPrice() + "\t\t商品的剩余库存为：" + item.getCount() + "\n请输入您要购买的数量");
                    while (true) {
                        Scanner scanner1 = new Scanner(System.in);
                        int buyNum = scanner1.nextInt();
                        if (buyNum < item.getCount() && buyNum > 0) {
                            System.out.println("您要购买的商品数量为：" + buyNum + "\t\t商品单价为" + item.getPrice() + "\t\t总价为" + item.getPrice() * buyNum);
                            System.out.println("是否确认购买该商品" + item.getName() + "\t\t输入y确认购买" + ",\t\t输入其他放弃购买");
                            Scanner scanner2 = new Scanner(System.in);
                            if ("y".equals(scanner2.next())) {

                                item.setCount(item.getCount() - buyNum);
                                GoodsItem temp = new GoodsItem();
                                temp.setId(item.getId());
                                temp.setName(item.getName());
                                temp.setCount(buyNum);
                                temp.setPrice((item.getPrice() * buyNum));
                                goodsItemCartList.add(temp);
                                temp = item;
                                showGoodsItem();
                                return goodsItemCartList;
                            } else {
                                System.out.println("您选择了放弃购买此商品");
                                break;
                            }
                        } else {
                            System.out.println("您输入的商品数量有误，请重新输入");
                        }
                    }
                }
            }
            if (!flag) {
                System.out.println("未找到您要的商品");
            }
        }
        return goodsItemCartList;
    }


    public void print(ArrayList<GoodsItem> cart) {
        System.out.println("\n===================================购物车=====================================");
        System.out.println("||\t\t\t商品名称\t\t商品编号\t\t商品总价\t\t\t\t\t数量\t\t\t   ||");
        for (GoodsItem item : cart) {
            System.out.println("|| \t" + item + "   ||");
        }
        System.out.println("=============================================================================\n\n");
    }

    // 初始化商品方法
    public void initGoods() throws IOException {
        String filePath = "shixun\\src\\demo1\\day06\\goodsdata\\encodedGoodsItem.txt";
        File file = new File(filePath);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s = null;
        String[] s1 = new String[4];
        while ((s = bufferedReader.readLine()) != null) {
            s1 = s.split(",");
            GoodsItem goods = new GoodsItem(s1[1], s1[0], Double.parseDouble(s1[2]), Integer.parseInt(s1[3]));
            goodsItem.add(goods);
        }
//        System.out.println("\n\n===========================商品列表=============================");
//        System.out.println("||\t\t\t商品名称\t\t商品编号\t\t商品单价\t\t库存\t\t\t ||");
//        for (GoodsItem good : goodsItem) {
//            System.out.println("|| \t" + good + " ||");
//        }
//        System.out.println("===============================================================\n\n");

    }
}
