package netflix;

public class Leetcode96 {
    public static void main(String[] args) {
        System.out.println(new Leetcode96().numTrees(3));

    }

    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}
