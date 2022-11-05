package aws;

import java.util.Arrays;

public class Leetcode_209 {
    public static void main(String[] args) {
        int [] data = {2,3,1,2,4,3};
        System.out.println(new Leetcode_209().minSubArrayLen(7, data));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0;i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target && left < nums.length) {
                result = Math.min(result, i+1-left);
                sum -= nums[left++];
            }
        }

        return result != Integer.MAX_VALUE ? result : 0;
    }
}
