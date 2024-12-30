package meta;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_141 {
    public static void main(String[] args) {
        NodeNext mfour = new NodeNext(-1);

        NodeNext zero = new NodeNext(0);
        zero.next = mfour;

        NodeNext two = new NodeNext(2);
        two.next = zero;

        NodeNext three = new NodeNext(3);
        three.next = two;
        mfour.next = two;

        System.out.println(new Leetcode_141().hasCycleV2(three));
    }

    public boolean hasCycle(NodeNext head) {
        NodeNext temp = head;
        Set<Integer> traverseNodes = new HashSet<>();
        while (temp != null) {
            int current = temp.val;
            if (traverseNodes.contains(current)) {
                return true;
            }
            traverseNodes.add(current);
            temp = temp.next;
        }

        return false;
    }

    public boolean hasCycleV2(NodeNext head) {
        if (head == null) {
            return false;
        }

        NodeNext slow = head;
        NodeNext fast = head.next;
        while (fast != null && fast.next != null &&  fast.next.next != null) {
            if (slow == null) {
                slow = head;
            }
            if (slow.equals(fast)) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;

        }
        return false;
    }
}
