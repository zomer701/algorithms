package amazon;

import structures.ListNode;

public class Leetcode234 {
    public static void main(String[] args) {
        ListNode f1 =  new ListNode(0);
        ListNode s2 =  new ListNode(2);
        ListNode s21 =  new ListNode(3);
        ListNode t3 =  new ListNode(2);
        ListNode f4 =  new ListNode(1);

        f1.next = s2;
        s2.next = t3;
        s21.next = t3;
        t3.next = f4;
//1 2 3 2 1
// 1 2 3 2 1
        System.out.println(isPalindrome(f1));
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode current = new ListNode(head.data);
        ListNode currentD = current;
        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            currentD.next = new ListNode(slow.data);
            currentD = currentD.next;

        }


        slow = reverseList(slow);

        return isSame(slow, current);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    static boolean isSame(ListNode first, ListNode second) {
        if (first == null && second == null) {
            return true;
        }

        while (first != null && second != null) {
            if ((int)first.data != (int)second.data) {
                return false;
            }
            first = first.next;
            second = second.next;
        }

        return true;
    }
}
