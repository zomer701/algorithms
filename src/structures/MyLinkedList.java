package structures;

public class MyLinkedList {
    private SinglyListNode head;
    public MyLinkedList() {
        head = null;
    }
    public int get(int index) {
        SinglyListNode node = getNode(index);
        return node != null ? node.val : -1;
    }

    private SinglyListNode getNode(int index) {
        if (index < 0) {
            return null;
        }

        if (index == 0) {
            return head;
        }

        SinglyListNode temp = head;
        while (temp != null && --index >= 0) {
            temp = temp.next;
        }

        return temp;
    }

    public void addAtHead(int val) {
        SinglyListNode newHead = new SinglyListNode(val);
        newHead.next = head;
        head = newHead;
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new SinglyListNode(val);
        } else {
            SinglyListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next =  new SinglyListNode(val);
        }
    }

    public void addAtIndex(int index, int val) {

        if (index == 0) {
            addAtHead(val);
            return;
        }

        SinglyListNode prevNode = getNode(index-1);
        if (prevNode != null) {
            SinglyListNode next = prevNode.next;
            SinglyListNode newNode = new SinglyListNode(val);
            newNode.next = next;
            prevNode.next = newNode;
        }
    }

    public void deleteAtIndex(int index) {

        if (index == 0 && head != null) {
            head = head.next;
            return;
        }

        SinglyListNode node = getNode(index-1);
        if (node != null && node.next != null) {
            node.next = node.next.next;
        }
    }

    public void print() {
        SinglyListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public class SinglyListNode {
        public int val;
        public SinglyListNode next;
        public SinglyListNode(int x) { val = x; }
    }
}
