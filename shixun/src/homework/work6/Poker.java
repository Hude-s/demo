package homework.work6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Poker {
    public static void main(String[] args) {

        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        List<String> poker = new ArrayList<>();
        initPoker(colors, numbers, poker);
        poker.add("大王");
        poker.add("小王");
        System.out.println("洗牌前：");
        System.out.println("poker = " + poker);
//        Collections.shuffle(poker);
//        System.out.println("poker = " + poker);

        //要求1：自定义洗牌方法
        washPoker(poker);
        System.out.println("洗牌后：");
        System.out.println("poker = " + poker);

        //要求2：发牌
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();
        List<String> bottomCards = new ArrayList<>();
        dealPoker(player1, player2, player3, poker, bottomCards);
        System.out.println("发牌后：");
        System.out.println("player1 = " + player1);
        System.out.println("player2 = " + player2);
        System.out.println("player3 = " + player3);
        System.out.println("bottomCards = " + bottomCards);

    }


    public static void initPoker(String[] colors, String[] numbers, List<String> poker) {
        for (String number : numbers) {
            for (String color : colors) {
                poker.add(number + color);
            }
        }
    }

    //打乱数组顺序-洗牌
    public static void washPoker(List<String> pokers) {
        Random random = new Random();
        for (int i = 0; i < pokers.size(); i++) {
            int randomNum = random.nextInt(pokers.size());//生成随机交换的位置（生成位置的随机数在数组的长度范围之内）
            String temp = pokers.get(randomNum);//把生成的随机位置的元素取出赋值给临时变量（随机位置数据保存）
            pokers.set(randomNum, pokers.get(i));//将随机位置的数据赋值为当前遍历到位置的数据（交换数据，设置随机位置的数据为当前位置数）
            pokers.set(i, temp);//将当前位置的数据改为随机位置的值（temp中保存的）
        }
    }

    public static void dealPoker(List<String> player1, List<String> player2, List<String> player3, List<String> poker, List<String> bottomCards) {
        for (int i = 0; i < poker.size(); i++) {
            if (i < 51) {
                switch (i % 3) {
                    case 0:
                        player1.add(poker.get(i));
                        break;
                    case 1:
                        player2.add(poker.get(i));
                        break;
                    case 2:
                        player3.add(poker.get(i));
                        break;
                }
            } else {
                bottomCards.add(poker.get(i));
            }
        }

    }


}
