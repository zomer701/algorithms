package aws;

public class Leetcode_5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length()-1; i++) {

            String iPalindromic = maxPalindromicProcess(s, i, i);
            if (iPalindromic.length() > result.length()) {
                result = iPalindromic;
            }

            String iPlusOnePalindromic = maxPalindromicProcess(s, i, i+1);
            if (iPlusOnePalindromic.length() > result.length()) {
                result = iPlusOnePalindromic;
            }
        }

        return result;
    }

    private static String maxPalindromicProcess(String s, int start, int end) {
        while (start >= 0 && end <= s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }

}
