package aws;

import structures.ListNode;

public class Leetcode_328 {
    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode event = head.next;
        ListNode eventHead = event;
        while (event != null && event.next != null) {
            odd.next = event.next;
            odd = odd.next;
            event.next = odd.next;
            event = event.next;
        }


        odd.next = eventHead;
        return head;
    }
}
