package aws;

import structures.ListNode;

public class Leetcode_206 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode next;
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
