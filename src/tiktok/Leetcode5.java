package tiktok;

public class Leetcode5 {
    public static void main(String[] args) {

    }

    public static String longestPalindrome(String s) {
        if (s == null && s.length() == 1) {
            return s;
        }

        String result = "";
        for (int i = 0 ; i < s.length() - 1; i ++) {
            String tmp = helper(s, i, i);
            if (tmp.length() > result.length()) {
                result = tmp;
            }

            String tmpIncrease = helper(s, i, i+1);

            if (tmpIncrease.length() > result.length()) {
                result = tmpIncrease;
            }

        }

        return result;
    }

    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) ==
                s.charAt(end)) {
            begin--;
            end++; }
        return s.substring(begin + 1, end);
    }

}
