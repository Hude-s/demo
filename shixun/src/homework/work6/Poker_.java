package homework.work6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Poker_ {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();
        List<String> poker = new ArrayList<>();

        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        initPoker(colors, numbers, poker);

        initOrder(hashMap, poker);
        System.out.println(poker);
        System.out.println(hashMap);
        washPoker(poker);
        System.out.println(poker);


    }


    public static void initPoker(String[] colors, String[] numbers, List<String> poker) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < colors.length; j++) {
                poker.add(colors[j] + numbers[i]);
            }
        }
        poker.add("小王");
        poker.add("大王");
    }

    public static void initOrder(HashMap<Integer, String> hashMap, List<String> poker) {
        for (int i = 0; i < poker.size(); i++) {
            hashMap.put(i, poker.get(i));
        }
    }

    //打乱数组顺序-洗牌
    public static void washPoker(List<String> pokers) {
        Random random = new Random();
        for (int i = 0; i < pokers.size(); i++) {
            int randomNum = random.nextInt(pokers.size());
            String temp = pokers.get(randomNum);
            pokers.set(randomNum, pokers.get(i));
            pokers.set(i, temp);
        }
    }


    public static void washPoker_(HashMap<Integer,String> hashMap){
        Random random = new Random();
        for (int i = 0; i < hashMap.size(); i++) {
            int randomNum = random.nextInt(hashMap.size());

        }


    }
    public static void dealPoker(List<String> player1, List<String> player2, List<String> player3, HashMap<Integer, String> hashMap, List<String> bottomCards) {
        for (int i = 0; i < hashMap.size(); i++) {
            if (i < 51) {
                switch (i % 3) {
                    case 0:
//                        player1.add(hashMap.g);
                        break;
//                    case 1:
//                        player2.add(poker.get(i));
//                        break;
//                    case 2:
//                        player3.add(poker.get(i));
//                        break;
//                }
//            } else {
//                bottomCards.add(poker.get(i));
                }
            }

        }

    }
}

