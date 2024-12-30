package meta;

import leetcode.Node;

public class Leetcode_708 {

    public static void main(String[] args) {
        NodeNext four = new NodeNext(4);
        NodeNext three = new NodeNext(3);
        NodeNext one = new NodeNext(1);
        three.next = four;
        four.next = one;


        NodeNext test = new Leetcode_708().insert(three, 2);
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
        while (cur != head.next) {
            if (cur.val >= val && cur.next != null && cur.next.val >= val) {
                break;
            }

            if (cur.val <= val && cur.next != null && cur.next.val <= val) {
                break;
            }


            cur = cur.next;
        }

        NodeNext next = cur.next;
        NodeNext newNode = new NodeNext(val);
        cur.next = newNode;
        newNode.next = next;


        return head;
    }
}
