package amazon;

import leetcode.Node;
import leetcode.Node2;

public class MergeList {

    static Node2 merge(Node2 l1, Node2 l2) {
        if (l1==null) {
            return l2;
        }

        if (l2==null) {
            return l1;
        }

        if (l1.getValue() <= l2.getValue()) {
            l1.setNext(merge(l1, l2.getNext()));
            return l1;
        } else {
            l2.setNext(merge(l2, l1.getNext()));
            return l2;
        }
    }
}
