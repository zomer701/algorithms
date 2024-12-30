package amazon;

public class Leetcode5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int max = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            int length = r - l - 1;
            if (length > max) {
                max = length;
                start = l + 1;
                end = r;
            }


            l = i;
            r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            length = r - l - 1;
            if (length > max) {
                max = length;
                start = l + 1;
                end = r;
            }
        }


        return s.substring(start, end);
    }
}
