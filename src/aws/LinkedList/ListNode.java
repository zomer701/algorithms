
public class ListNode {
    int val;
    ListNode next;
    ListNode random;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(ListNode random, int val) {
        this.val = val;
        this.random = random;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
