package homework.work6;

import java.util.*;

public class Poker_1 {
    public static void main(String[] args) {
        List<Integer> pokerOrder = new ArrayList<>();
        HashMap<Integer, String> poker = new HashMap<>();

        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A","2"};

        initPoker(poker, pokerOrder, colors, numbers);
        System.out.println(poker);
        System.out.println(pokerOrder);
        washOrder(pokerOrder);
        System.out.println(pokerOrder);


        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        List<Integer> player3 = new ArrayList<>();
        List<Integer> bottomNum = new ArrayList<>();

        dealPokerOrder(pokerOrder, player1, player2, player3, bottomNum);
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(bottomNum);

        catPlayerPoker(player1, poker);
        catPlayerPoker(player2, poker);
        catPlayerPoker(player3, poker);
        catPlayerPoker(bottomNum, poker);


    }

    public static void initPoker(HashMap<Integer, String> poker, List<Integer> pokerOrder, String[] colors, String[] numbers) {
        for (int i = 0; i < 54; i++) {
            pokerOrder.add(i);
        }
        int count = 0;

        for (String number : numbers) {
            for (String color : colors) {
                poker.put(count++, number + color);
            }
        }
        poker.put(count++, "小王");
        poker.put(count++, "大王");
    }

    public static void washOrder(List<Integer> pokerOrder) {
        Random random = new Random();
        for (int i = 0; i < pokerOrder.size(); i++) {
            int randomNum = random.nextInt(pokerOrder.size());
            int temp = pokerOrder.get(i);
            pokerOrder.set(i, pokerOrder.get(randomNum));
            pokerOrder.set(randomNum, temp);
        }
    }

    public static void dealPokerOrder(List<Integer> pokerOrder, List<Integer> player1, List<Integer> player2, List<Integer> player3, List<Integer> bottomNum) {
        for (int i = 0; i < pokerOrder.size(); i++) {
            if (i < 51) {
                switch (i % 3) {
                    case 0:
                        player1.add(pokerOrder.get(i));
                        break;
                    case 1:
                        player2.add(pokerOrder.get(i));
                        break;
                    case 2:
                        player3.add(pokerOrder.get(i));
                        break;
                }
            } else {
                bottomNum.add(pokerOrder.get(i));
            }
        }
        player1.sort(Integer::compareTo);
        player2.sort(Integer::compareTo);
        player3.sort(Integer::compareTo);
        bottomNum.sort(Integer::compareTo);
    }

    public static void catPlayerPoker(List<Integer> player, HashMap<Integer, String> pokers) {
        for (int i = 0; i < player.size(); i++) {
            String poker = pokers.get(player.get(i));
            System.out.print(poker + " ");
        }
        System.out.println("\n");
    }
}
