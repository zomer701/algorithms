package tiktok;

import structures.ListNode;

public class Leetcode206 {

    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
