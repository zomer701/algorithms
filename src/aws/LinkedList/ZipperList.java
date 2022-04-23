public class ZipperList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(6);
        ListNode node24 = new ListNode(8);

        node21.next = node22;
        node22.next = node23;
        node23.next = node24;


        ListNode current = new ZipperList().zip(node1, node21);
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

    public ListNode zip(ListNode node1, ListNode node21) {
        ListNode tail = node1;
        ListNode current1 = node1.next;
        ListNode current2 = node21;

        boolean check = false;

        while (current1 != null && current2 !=null)
        {
            if (check) {
                tail.next = current1;
                current1 = current1.next;
            } else {
                tail.next = current2;
                current2 = current2.next;
            }

            tail = tail.next;
            check = !check;
        }

        if (current1 != null) {
            tail.next = current1;
        }

        if (current2 != null) {
            tail.next = current2;
        }

        return node1;
    }
}
