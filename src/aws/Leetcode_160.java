package aws;

import structures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_160 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        ListNode node11 = new ListNode(6);
        ListNode node22 = new ListNode(1);
        ListNode node33 = new ListNode(8);
        ListNode node44 = new ListNode(4);

        node11.next = node22;
        node22.next = node33;
        node33.next = node44;


        System.out.println(new Leetcode_160().getIntersectionNode(node11, node1).data);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> builder = new HashSet();
        while (headA != null) {
            builder.add(headA);
            headA = headA.next;
        }


        while (headB != null) {
            if (builder.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
