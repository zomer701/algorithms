package google;

public class Leetcode_680 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_680().validPalindrome("abca"));
        System.out.println(new Leetcode_680().validPalindrome("aba"));
        System.out.println(new Leetcode_680().validPalindrome("abba"));
        System.out.println(new Leetcode_680().validPalindrome("fabbaf"));
        System.out.println(new Leetcode_680().validPalindrome("a"));
        System.out.println(new Leetcode_680().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public boolean validPalindrome(String s) {
        int end = s.length()-1;

        if (end <= 0) {
            return true;
        }

        int start = 0;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
               if (validPalindromeValue(s, start+1, end) || validPalindromeValue(s, start, end-1)) {
                   return true;
               }

               return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public boolean validPalindromeValue(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
