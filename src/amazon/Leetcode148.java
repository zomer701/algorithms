package amazon;

import structures.ListNode;

public class Leetcode148 {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
           return head;
        }

        ListNode l1 = head;
        ListNode l2 = splitMid(head);
        sortList(l1);
        sortList(l2);

        ListNode dammy = new ListNode();
        ListNode rest = dammy;

        while (l1 != null && l2 != null) {
            if ((int)l1.data < (int)l2.data) {
                rest.next = l1;
                l1 = l1.next;
            } else {
                rest.next = l2;
                l2 = l2.next;
            }
            rest=rest.next;
        }

        if (l2 != null) {
            rest.next = l2;
        }

        if (l1 != null) {
            rest.next = l1;
        }

        return dammy.next;
    }

    private ListNode splitMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while ( fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        return slow;
    }
}
