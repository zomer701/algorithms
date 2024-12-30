package google;

import structures.ListNode;

public class Leetcode_19 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;


        ListNode node = new Leetcode_19().removeNthFromEnd(node1, 2);

        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        count -= n;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        temp = dummy;
        while (count > 0) {
            count--;
            temp = temp.next;
        }
        temp.next = temp.next.next;


        return dummy.next;
    }
}
