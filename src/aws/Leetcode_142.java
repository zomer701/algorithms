package aws;

import structures.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {

        Set<ListNode> memo = new HashSet<>();

        ListNode node = head;
        while(node != null) {
            if (memo.contains(node)) {
                return node;
            }

            memo.add(node);
            node = node.next;
        }


        return null;
    }
}
