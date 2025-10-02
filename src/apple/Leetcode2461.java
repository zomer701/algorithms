package apple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Leetcode2461 {
    public static void main(String[] args) {
        int [] nums = {1,5,4,2,9,9,9};
        int k = 3;

        System.out.println(maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long currentSum = 0;
        int begin = 0;
        int end = 0;

        HashMap<Integer, Integer> numToIndex = new HashMap<>();
        while (end < nums.length) {
            int currNum = nums[end];
            int lastOccurrence = numToIndex.getOrDefault(currNum, -1);

            while (begin <= lastOccurrence || end - begin + 1 > k) {
                currentSum -= nums[begin];
                begin++;
            }

            numToIndex.put(currNum, end);
            currentSum += nums[end];
            if (end - begin + 1 == k) {
                ans = Math.max(ans, currentSum);
            }
            end++;

        }

        return ans;
    }
}
