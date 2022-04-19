public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;


//        while (node1 != null)
//        {
//            System.out.println(node1.val);
//            node1 = node1.next;
//        }

        System.out.println("new node1");
        ListNode result = new ReverseLinkedList().reverseList(node1);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }
//1 next -> 2
//2 next -> 3
//3 next -> null

//3 next -> 2
//2 next -> 1
//1 next -> null

    public ListNode reverseList(ListNode head) {
        ListNode next;
        ListNode current = head;
        ListNode prev = null;

        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
