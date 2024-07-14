package amazon;

public class Leetcode28 {
    public static void main(String[] args) {

    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < 1 || needle.length() < 1 || needle.length() > haystack.length()) {
            return -1;
        }

        return haystack.indexOf(needle);
    }

    public int strStr2(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();

        for (int windowStart = 0; windowStart <= n - m; windowStart++) {
            for (int i = 0; i < m; i++) {
                if (needle.charAt(i) != haystack.charAt(windowStart + i)) {
                    break;
                }
                if (i == m - 1) {
                    return windowStart;
                }
            }
        }

        return -1;
    }
}
