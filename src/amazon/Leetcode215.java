package amazon;

import java.util.Comparator;
import java.util.TreeSet;

public class Leetcode215 {
    public static void main(String[] args) {

        int [] nums = {-1,-1};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int i: nums) {
            max = Math.max(max, i);
        }

        int[] numMemo = new int[max+1];
        for (int num: nums) {
            numMemo[num] = numMemo[num]+1;
        }

        for (int i = numMemo.length-1; i >=0 ; i --) {
            k-=numMemo[i];
            if (k < 0) {
                return i;
            }
        }

        return -1;
    }
}
