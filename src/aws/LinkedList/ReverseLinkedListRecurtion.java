public class ReverseLinkedListRecurtion {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode prev = null;
        ListNode result = new ReverseLinkedListRecurtion().reverseList(node1, prev);
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

    public ListNode reverseList(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }
//3
        ListNode next = head.next;
        head.next = prev;
        return reverseList(next, head);
    }
}
