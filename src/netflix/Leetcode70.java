package netflix;

public class Leetcode70 {

    public static void main(String[] args) {
        System.out.println(new Leetcode70().climbStairs(3));
    }
    public int climbStairs(int n) {
        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n+1];
       return climbStairs(n, dp);
    }

    private int climbStairs(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
