package demo.struct;

import java.util.Random;

public class MergeTwoList {

    public static void main(String[] args) {
        Random random = new Random();
        ListNode listNode = new ListNode(random.nextInt(50));
        ListNode listNode1 = new ListNode(random.nextInt(50));


        System.out.println("头插法创建");
        //头插法创建
        for (int i = 0; i < 5; i++) {

            ListNode temp = listNode.next;
            listNode.next = new ListNode(random.nextInt(50));
            System.out.print(listNode.val + "  ");
            listNode.next = temp;
        }
        System.out.println("\n");
//
        for (int i = 0; i < 4; i++) {
            listNode1.next = new ListNode(random.nextInt(50));

            System.out.print(listNode1.val + "  ");
//            listNode1 = listNode1.next;
            ListNode temp = listNode1.next;
        }

        System.out.println("\n-----------------");
        while (listNode1.next != null) {
            System.out.print(" " + listNode1.val);
            listNode1 = listNode1.next;
        }
        System.out.println("\n-------**********");

        MergeTwoList mergeTwoList = new MergeTwoList();
        listNode = mergeTwoList.createNode_headInsert(listNode, 0);
        System.out.println("\n=========");
        while (listNode != null) {
            System.out.print(" " + listNode.val);
            listNode = listNode.next;
        }

    }

    //创建链表使用 头插法/尾插法


    public ListNode createNode_headInsert(ListNode node, int i) {
        //创建生成随机数对象
        Random random = new Random();
        ListNode node1 = new ListNode();
        if (i < 5) {
            //创建新结点
            ListNode newNode = new ListNode(random.nextInt(50));
            if (i == 0)
                node1.next = newNode;
            //把新结点next域置null
            newNode.next = null;
            //把下一个结点的引用赋值给
            node.next = newNode;
            System.out.print(" " + newNode.val);
            createNode_headInsert(node, ++i);
        }
        return node1;
    }


}


