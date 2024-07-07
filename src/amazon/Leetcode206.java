package amazon;

import structures.ListNode;

public class Leetcode206 {
    public static void main(String[] args) {

    }
//prev current next
 // 1 null 2 3 4 5

//null 1,2,3,4,5
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;


        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
