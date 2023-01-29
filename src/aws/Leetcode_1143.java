package aws;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Leetcode_1143 {
    int dp[][]=new int[1001][1001];
    public static void main(String[] args) {
        System.out.println(new Leetcode_1143().longestCommonSubsequence("ixefcvarevabmfabqfivodqfaluxqp","cxwfkzyxabytijcnohgzgbchwpshwnu"));
    }

    public int longestCommonSubsequence(String text1, String text2) {

            return dp(0, 0, text1, text2);
    }

    private int dp(int index, int index2, String text1, String text2) {
        if (index >= text1.length() || index2 >= text2.length()) {
            return 0;
        }

        if(dp[index][index2]!=0)return dp[index][index2];

        if (text1.charAt(index) == text2.charAt(index2)) {
            dp[index][index2] = 1 + dp(index + 1, index2 + 1, text1, text2);
        } else {
            dp[index][index2] = Math.max(dp(index, index2 + 1, text1, text2), dp(index + 1, index2, text1, text2));
        }


        return dp[index][index2];
    }
}
