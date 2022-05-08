public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode current = new ReverseNodesInKGroup().reverseKGroup(node1, 2);
        while (current != null)
        {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode prev = null;
        int index = 0;


        while (current != null)
        {
            if (index != 0 || index % k == 0) {
                System.out.println("index" + index);
            } else {
                ListNode next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }

            index ++;
        }

        return prev;
    }
}
