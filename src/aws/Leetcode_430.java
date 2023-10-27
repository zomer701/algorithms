package aws;

import leetcode.Node;

public class Leetcode_430 {

    public static void main(String[] args) {

    }
    public Node flatten(Node head) {
        Node temp = head;
        process(temp, null);

        return head;
    }

    private void process(Node current, Node parentNext) {
        if (current == null) {
            return;
        }


        Node prev = current;
        while (current != null) {
            if (current.child != null) {
                Node next = current.next;
                Node child = current.child;
                current.next = child;
                child.prev = current;
                current.child = null;



                process(child, next == null ? parentNext : next);
                prev = next;
                current = next;

                continue;
            }



            prev = current;
            current = current.next;
        }
        if ( prev != null && parentNext != null) {
            prev.next = parentNext;
            parentNext.prev = prev;
        }
    }


    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
