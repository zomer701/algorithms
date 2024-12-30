package amazon;

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode215V2 {
    public static void main(String[] args) {

        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.print(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int num: nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        int[] count = new int[maxValue - minValue + 1];
        for (int num: nums) {
            count[num - minValue]++;
        }

        int remain = k;
        for (int num = count.length - 1; num >= 0; num--) {
            remain -= count[num];
            if (remain <= 0) {
                return num + minValue;
            }
        }

        return -1;
    }
}
