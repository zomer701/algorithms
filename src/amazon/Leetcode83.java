package amazon;

import structures.ListNode;

public class Leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode prev = head;

        while (head != null && prev.next != null) {
            if (prev.next.data == prev.data) {

                prev.next = prev.next.next;

            }  else {
                prev = prev.next;
            }
        }

        return head;
    }
}
