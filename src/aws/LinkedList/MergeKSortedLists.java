public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;


        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node33 = new ListNode(8);

        node11.next = node22;
        node22.next = node33;

        ListNode[] lists = {node1, node11};

        ListNode head = new MergeKSortedLists().mergeKLists(lists);

        while (head != null)
        {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;

        for (ListNode data: lists)
        {
            if (head == null) {
                head = data;
            } else {
                head = mergeTwoLists(head, data);
            }
        }

        return head;
    }


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
