public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(6);
        ListNode node24 = new ListNode(7);

        node21.next = node22;
        node22.next = node23;
        node23.next = node24;


        ListNode current = new MergeTwoSortedLists().mergeTwoLists(node1, node21);
        while (current != null)
        {
            System.out.println(current.val);
            current = current.next;
        }
    }


//1 next -> 2
//2 next -> 3
//3 next -> null

//3 next -> 2
//2 next -> 1
//1 next -> null

    public ListNode mergeTwoLists(ListNode node1, ListNode node21) {

        if (node1 == null) {
            return node21;
        }

        if (node21 == null) {
            return node1;
        }

        ListNode tail = new ListNode(0);
        ListNode temp = tail;

        while (node1 != null && node21 !=null)
        {
            int check1 = node1.val;
            int check2 = node21.val;

            if (check1 <= check2) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node21;
                node21 = node21.next;
            }

            temp = temp.next;
        }

        if (node1 != null) {
            temp.next = node1;
        }

        if (node21 != null) {
            temp.next = node21;
        }

        return tail.next;
    }
}
