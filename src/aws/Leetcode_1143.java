package aws;

public class Leetcode_1143 {

    public static void main(String[] args) {
        System.out.println(new Leetcode_1143().longestCommonSubsequence("ixefcvarevabmfabqfivodqfaluxqp","cxwfkzyxabytijcnohgzgbchwpshwnu"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int text1l = text1.length();
        int text2l = text2.length();
        int[][] dp = new int[text1l+1][text2l+1];

        for (int i = 1; i <=text1l; i++) {
            for (int j = 1; j <= text2l; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] =  1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1l][text2l];
    }

}
