package amazon;

import structures.ListNode;

public class Leetcode21 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {

        ListNode temp = new ListNode();
        ListNode result = temp;

        while (node1 != null && node2 != null) {
            int node2Val = (int)node2.data;
            int node1Val = (int)node1.data;

            if (node1Val <= node2Val) {
                result.next = new ListNode(node1Val);
                node1 = node1.next;
            } else {
                result.next = new ListNode(node2Val);
                node2 = node2.next;
            }

            result = result.next;
        }

        if (node1 != null) {
            result.next = node1;
        } else {
            result.next = node2;
        }

        return temp.next;
    }
}
