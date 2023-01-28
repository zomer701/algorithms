package aws;

import structures.ListNode;

public class Leetcode_148 {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (left != null && right != null) {
            if ((Integer)left.data < (Integer)right.data) {
                tail.next = left;
                left = left.next;
                tail = tail.next;
            } else {
                tail.next = right;
                right = right.next;
                tail = tail.next;
            }
        }
        tail.next = (left != null) ? left : right;
        return dummy.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode midPren = null;
        while (head != null && head.next != null) {
            midPren = midPren == null ? head : midPren.next;
            head = head.next.next;
        }

        ListNode mid = midPren.next;
        midPren.next = null;
        return mid;
    }
}
