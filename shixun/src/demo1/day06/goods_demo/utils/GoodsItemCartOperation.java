package demo1.day06.goods_demo.utils;

import demo1.day06.goods_demo.entity.GoodsItem;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// 购物车操作类
/*
 * 1. 初始化商品  打印商品
 * 2. 加入商品到购物车
 * 3. 打印购物车商品数据
 * */
public class GoodsItemCartOperation {

    private ArrayList<GoodsItem> goodsItem;   // 定义一个商品集合类对象

    private final String goodsFilePath = "shixun\\src\\demo1\\day06\\goods_demo\\goodsdatas\\encodedGoodsItem.txt";

    public GoodsItemCartOperation(ArrayList<GoodsItem> goodsItem) throws Exception {
        this.goodsItem = goodsItem;
    }


    //    打印商品列表
    public void showGoodsItem(ArrayList<GoodsItem> goodsItem) {
        if (goodsItem.size() == 0) {
            System.out.println("======当前商品库存为零======");
            return;
        }
        System.out.println("======商品库存如下表：======");
        System.out.println("商品名\t\t货号\t\t单价\t\t数量");
        for (int i = 0; i < goodsItem.size(); i++) {
            GoodsItem tmp = goodsItem.get(i);
            System.out.println(tmp.getName() + "\t" + tmp.getId() + "\t\t" + tmp.getPrice() + "\t" + tmp.getCount());
        }
        System.out.println("======以上就是全部库存======");
    }

    // 购买商品方法
    public ArrayList<GoodsItem> buyGoodsItem() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<GoodsItem> goodsItemCartList = new ArrayList<>();//每次进入购买操作，创建一个新的购物车
        while (true) {
            if (goodsItem.size() == 0) {
                System.out.println("==当前商品库存为零,无法继续购买==");
            }
            System.out.println("输入0退出购买");
            System.out.println("请输入想要购买的商品货号");
            String idbuy = scanner.nextLine();
            if (idbuy.equals("0")) {//输入0时退出购买方法
                return goodsItemCartList;//返回购物车列表
            }
            for (int i = 0; i < goodsItem.size(); i++) {
                System.out.println(".");
                if (idbuy.equals(goodsItem.get(i).getId())) {//如果货号输入正确，则进行下一步输入数量
                    while (true) {
                        System.out.println("请输入想要购买的商品数量");
                        int countbuy = scanner.nextInt();
                        scanner.nextLine();
                        if (countbuy == 0) {//输入0时退出购买方法
                            return goodsItemCartList;//返回购物车列表
                        }

                        if (countbuy > 0 && countbuy <= goodsItem.get(i).getCount()) {//输入数量大于0，小于剩余库存时，购买成功
                            goodsItem.get(i).setCount(goodsItem.get(i).getCount() - countbuy);//更新商品库存
                            System.out.println("购买成功");
                            GoodsItem tmp = new GoodsItem(goodsItem.get(i).getName(), idbuy, goodsItem.get(i).getPrice(), countbuy);//创建一个已购买的商品对象
                            goodsItemCartList.add(tmp);//把已购买商品对象加入购物车列表
                            break;
                        }
                        System.out.println("您输入的数量有误，请重新输入");
                    }
                    break;
                }
            }

        }
    }

    //打印小票
    public void print(ArrayList<GoodsItem> buyGoodsItem) {
        if (buyGoodsItem == null || buyGoodsItem.size() == 0) {
            System.out.println("您未购买商品");
            return;
        }
        double pricebuy = 0;
        System.out.println("=========您的购物清单：=========");
        System.out.println("商品名\t货号\t\t\t单价\t\t数量");
        for (int i = 0; i < buyGoodsItem.size(); i++) {
            Boolean judge = false;
            GoodsItem tmp = buyGoodsItem.get(i);
            for (int j = i + 1; j < buyGoodsItem.size(); j++) {
                if (tmp.getId().equals(buyGoodsItem.get(j).getId())) {
                    buyGoodsItem.get(j).setCount(tmp.getCount() + buyGoodsItem.get(j).getCount());
                    judge = true;
                }
            }
            if (judge) {
                continue;
            }
            pricebuy = pricebuy + tmp.getCount() * tmp.getPrice();//计算总价
            System.out.println(tmp.getName() + "\t\t" + tmp.getId() + "\t" + tmp.getPrice() + "\t" + tmp.getCount());
        }
        System.out.println("=====您本次共消费" + pricebuy + "元=====");
    }

    // 初始化商品方法
    public ArrayList<GoodsItem> initGoods() throws Exception {

        FileReader file = new FileReader(new File(goodsFilePath));
        BufferedReader bufferedreader = new BufferedReader(file);

        String line;//暂时储存读到的数据
        while ((line = bufferedreader.readLine()) != null) {
            String[] split = line.split(",");//把每一行数据按“，”分割成字符串数组
            String name = split[1];
            String id = split[0];
            double price = Double.parseDouble(split[2]);//把括号里的数据变成double类型
            int count = Integer.parseInt(split[3]);
            GoodsItem tmp = new GoodsItem(name, id, price, count);//创建一个商品对象
            goodsItem.add(tmp);//把每一个商品对象加到商品列表里
        }
        bufferedreader.close();
        file.close();
        return goodsItem;
    }

    //重写数据数据，更新库存
    public void writeGoods() throws Exception {
        FileWriter file = new FileWriter(new File(goodsFilePath));
        BufferedWriter bufferedWriter = new BufferedWriter(file);
        for (int i = 0; i < goodsItem.size(); i++) {
            String name = goodsItem.get(i).getName();
            String id = goodsItem.get(i).getId();
            double price = goodsItem.get(i).getPrice();
            int count = goodsItem.get(i).getCount();
            bufferedWriter.write(name + "," + id + "," + price + "," + count + "\n");//把要输出的数据放进缓冲区
//            bufferedWriter.newLine();
        }
        bufferedWriter.close();//把缓冲区的数据写入文件顺便释放缓冲区
    }


}