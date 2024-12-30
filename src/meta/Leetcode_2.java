package meta;

import structures.ListNodeInt;

public class Leetcode_2 {
    public static void main(String[] args) {

    }

    public ListNodeInt addTwoNumbers(ListNodeInt l1, ListNodeInt l2) {
        ListNodeInt temp = new ListNodeInt(-1);
        ListNodeInt current = temp;
        boolean count = false;
        while (l1 != null || l2 != null) {
            int valueL1 = l1 != null ? l1.data : 0;
            int valueL2 = l2 != null ? l2.data : 0;
            int sum = (count ? 1 : 0) + valueL1 + valueL2;
            count = sum > 9;
            sum = count ? sum % 10 : sum;

            current.next = new ListNodeInt(sum);

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;

            current = current.next;
        }

        if (count) {
            current.next = new ListNodeInt(1);
        }


        return temp.next;
    }
}
