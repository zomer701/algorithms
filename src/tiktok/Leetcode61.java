package tiktok;

import structures.ListNode;

public class Leetcode61 {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);

        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        new Leetcode61().rotateRight(one, 2);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;  // No need to rotate
        }

        ListNode current = head;
        int length = 1;  // List length
        while (current.next != null) {
            current = current.next;
            length++;
        }

        current.next = head;

        k = k % length;  // Handle cases where k >= length
        int newTailPosition = length - k;

        ListNode newTail = head;
        for (int i = 1; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
