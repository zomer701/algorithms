import java.math.BigInteger;

public class AddTwoNumbers
{
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;


        ListNode node11 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node33 = new ListNode(4);

        node11.next = node22;
        node22.next = node33;

        ListNode result = new AddTwoNumbers().addTwoNumbers(node11, node1);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode save = new ListNode(0);
        ListNode temp = save;
        boolean count = false;
        while (l1 != null || l2 != null)
        {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum =  x + y + (count ? 1 : 0);
            count = sum > 9;

            sum = count ? sum % 10 : sum;

            temp.next = new ListNode(sum);

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            temp = temp.next;
        }

        if (count) {
            temp.next = new ListNode(1);
        }

        return save.next;
    }
}
