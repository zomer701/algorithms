package google;

import structures.ListNode;

public class Leetcode_143 {

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


        new Leetcode_143().reorderList(node1);

        ListNode temp = node1;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }

    }
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count ++;
            temp = temp.next;
        }

        int mid = count/2;
        temp = head;

        ListNode prevTemp = null;

        while (temp != null) {
            if (mid > 0) {
                temp = temp.next;
                mid--;
            } else {
                ListNode currentTemp = temp.next;
                ListNode nextTemp;
                while (currentTemp != null) {
                    nextTemp = currentTemp.next;
                    currentTemp.next = prevTemp;
                    prevTemp = currentTemp;
                    currentTemp = nextTemp;
                }
                temp.next = null;
                break;
            }
        }


        ListNode first = head, second = prevTemp, tmp;
        while (second != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}
