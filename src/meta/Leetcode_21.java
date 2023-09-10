package meta;

import structures.ListNodeInt;

public class Leetcode_21 {
    public static void main(String[] args) {
        var nodeO = new ListNodeInt(0);
        var node1 = new ListNodeInt(1);

        var node = new Leetcode_21().mergeTwoLists(nodeO, node1);
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    public ListNodeInt mergeTwoLists(ListNodeInt node1, ListNodeInt node2) {

        ListNodeInt temp = new ListNodeInt();
        ListNodeInt result = temp;
        while (node1 != null && node2 != null) {
            if(node1.data < node2.data) {
                result.next = node1;
                result = result.next;
                node1 = node1.next;
            } else {
                result.next = node2;
                result = result.next;
                node2 = node2.next;
            }
        }

        while (node2 != null) {
            result.next = node2;
            result = result.next;
            node2 = node2.next;
        }

        while (node1 != null) {
            result.next = node1;
            result = result.next;
            node1 = node1.next;
        }


        return temp.next;
    }
}
