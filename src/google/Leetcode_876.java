package google;

import structures.ListNode;

public class Leetcode_876 {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count ++;
            temp = temp.next;
        }


        int mid = count/2;
        count = 0;
        temp = head;
        while (count < mid) {
            temp = temp.next;
            count++;
        }

        return temp;

    }

}
