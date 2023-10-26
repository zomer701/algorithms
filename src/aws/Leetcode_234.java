package aws;

import structures.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_234 {
    public static void main(String[] args) {
        System.out.println(5/2);
    }

    public boolean isPalindrome(ListNode head) {

        ListNode temp = head;
        List<Integer> vals = new ArrayList<>();
        while (temp != null) {
            vals.add((Integer) temp.data);
            temp = temp.next;
        }

        int start = 0;
        int end = vals.size();

        while (start < end) {
            if (vals.get(start) != vals.get(end)) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }
}
