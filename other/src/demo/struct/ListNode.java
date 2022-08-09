package demo.struct;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    //传入单链表的头节点
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = null;
        while (list1.next != null && list2.next != null) {
            node = new ListNode();
            if (list1.val < list2.val) {
                node = list1;
                list1 = list1.next;
            } else {
                node = list2;
                list2 = list2.next;
            }
        }
        return node;
    }
/**
 public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
 ListNode node;
 while (list1.next == null && list2.next == null) {
 if (list1.val < list2.val) {
 node = list2;
 node.next = list1.next.next;
 list1.next = node;

 } else {
 node = list1;
 node.next = list2.next.next;
 list2.next = node;

 }
 }
 return null;
 }
 */
//    public void CreateList() {
//        Random random = new Random();
//        for (int i = 0; i < 10; i++) {
//            ListNode listNode = new ListNode(random.nextInt(50));
//            listNode.next = new ListNode(random.nextInt(50));
//            listNode.next.next = listNode.next;
//            if (listNode.next != null) {
//                System.out.print("listNode.val = " + listNode.val + "  " + i + "  ");
//                listNode = listNode.next;
//            }
//        }
//    }
}
