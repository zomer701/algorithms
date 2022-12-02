package aws;

public class Leetcode_198 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int N = nums.length;

        if  (nums.length < 1) {
            return 0;
        }

        int[] memo = new int[N];
        memo[N] = 0;
        memo[N-1] = nums[N-1];

        for (int i = N - 2; i >= 0; --i) {

            // Same as the recursive solution.
            memo[i] = Math.max(memo[i + 1], memo[i + 2] + nums[i]);
        }

        return memo[0];
    }
}
