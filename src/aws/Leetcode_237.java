package aws;

import structures.ListNode;

public class Leetcode_237 {
    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.data = next.data;
        node.next = next.next;
        next.next = null;
    }
}
