package amazon;

import structures.ListNode;

public class Leetcode24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (head != null && head.next != null) {
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            head = firstNode.next;
            prev = firstNode;
        }


        return dummy.next;
    }
}
