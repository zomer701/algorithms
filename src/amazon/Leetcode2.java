package amazon;

import structures.ListNode;

public class Leetcode2 {
    public static void main(String[] args) {

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(-1);
        ListNode current = temp;
        boolean count = false;

        while (l1 != null || l2 != null) {

            int vall1 = l1 != null ? (int)l1.data : 0;

            int vall2 = l2 != null ?  (int)l2.data : 0;

            int sum = (count ? 1 : 0) + vall1 + vall2;
            count =  sum > 9;
            current.next = new ListNode(sum%10);

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            current = current.next;
        }
        return temp.next;
    }
}
