public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;


        ListNode current = new ReverseLinkedList().reverseList(node1);
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

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null)
        {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
