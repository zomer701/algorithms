package aws;

import structures.ListNode;

public class Leetcode_328 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        ListNode current = new Leetcode_328().oddEvenList(node1);
        while (current != null)
        {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }


        ListNode temp = head;
        ListNode events = new ListNode(-1);
        ListNode headtemp = events;
        while (temp != null && temp.next != null) {
            ListNode next = temp.next;
            ListNode stepNext = next.next;

            next.next = null;
            events.next = next;
            events = events.next;
            temp.next = stepNext;
            temp = temp.next;
        }

        temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = headtemp.next;
        return head;
    }
}
