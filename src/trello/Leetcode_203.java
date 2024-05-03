package trello;

import structures.ListNode;

public class Leetcode_203 {
    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode currentHead = head;

        while (currentHead != null) {
            int current = (int)currentHead.data;
            if (current != val) {
                prev.next = currentHead.next;
            } else {
                prev = prev.next;
            }
            currentHead = currentHead.next;

        }


        return dummy.next;
    }
}
