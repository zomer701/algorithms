package meta;

import leetcode.Node;

public class Leetcode_708 {

    public static void main(String[] args) {
        NodeNext four = new NodeNext(4);
        NodeNext three = new NodeNext(3);
        NodeNext one = new NodeNext(1);
        three.next = four;
        four.next = one;


        NodeNext test = new Leetcode_708().insert(null, 2);
        while (test != null) {
            System.out.println(test.val);
            test = test.next;
        }

    }

    public NodeNext insert(NodeNext head, int val) {
        NodeNext node = new NodeNext(val);
        if (head == null) {
            node.next = node;
            return node;
        }

        NodeNext cur = head;
        while (cur.next != head) {
            if (cur.val <= val && val <= cur.next.val) break;
            if (cur.val > cur.next.val && (cur.val < val || val < cur.next.val)) break;
            cur = cur.next;
        }

        node.next = cur.next;
        cur.next = node;
        return head;
    }
}
