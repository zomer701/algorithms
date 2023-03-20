package aws;

public class Leetcode_198 {
    public static void main(String[] args) {
        System.out.println(rob(new int []{1,2,3,1}));
    }

    static int rob(int[] nums) {
        int n = nums.length;
        // dp[i] = x: start rob at i-th house, the maximum money you can get is x
        // base case: dp[n] = 0
        int[] dp = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }
}
