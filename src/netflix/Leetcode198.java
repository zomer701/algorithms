package netflix;

public class Leetcode198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(new Leetcode198().rob(nums));
    }

    public static int rob(int[] nums) {
        int L = nums.length;
        if (L == 1) {
            return nums[0];
        }

        if (L == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]); // Recurrence relation
        }

        return dp[nums.length - 1];
    }

}
