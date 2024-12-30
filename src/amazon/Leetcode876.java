package amazon;

import structures.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode876 {
    public static void main(String[] args) {

    }

    public ListNode middleNode2(ListNode head) {
        ListNode fast = head;
        ListNode sfast = head.next;

        while (sfast.next != null) {
            fast = fast.next;
            sfast = sfast.next.next;
        }

        return fast;
    }

    public ListNode middleNode(ListNode head) {

        ListNode temp = head;

        List<Integer> memo = new ArrayList<>();

        while (temp != null) {
            memo.add((int)temp.data);
            temp = temp.next;
        }

        if (memo.size() <= 1) {
            return head;
        }

        int mid = memo.size()/2;

        temp = head;
        while (mid >= 0) {
            temp = temp.next;
            mid--;
        }

        return temp;
    }
}
