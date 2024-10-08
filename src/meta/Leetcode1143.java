package meta;

public class Leetcode1143 {

    public static void main(String[] args) {
        System.out.println(new Leetcode1143().longestCommonSubsequence("sbininm", "jmjkbkjkv"));
    }

//    "bsbininm"
//    "jmjkbkjkv"

    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {

                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] =   dp[i-1][j] + 1;

                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

                System.out.print(String.format("I %s J %s VAlUE %s ", i, j , dp[i][j]));
            }
            System.out.println("---------");
        }

        return dp[text1.length()-1][text2.length()-1];
    }
}
