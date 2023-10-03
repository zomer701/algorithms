package google;

import structures.ListNode;

public class Leetcode_92 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode current = new Leetcode_92().reverseBetween(node1, 1 , 3);

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

//    public ListNode reverseBetween(ListNode head, int left, int right) {
//
//    }
  //  prev current next
public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode before = dummy;
        for (int i = 1; i < left; i++) {
            before = before.next;
        }

        ListNode prev = before;
        ListNode current = before.next;

    for (int i = left; i <= right; i++) {
        ListNode next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }

    before.next.next = current;
    before.next = prev;

    return dummy.next;
    }
}
