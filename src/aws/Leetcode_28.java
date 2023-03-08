package aws;

public class Leetcode_28 {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < 1 || needle.length() < 1 || needle.length() > haystack.length()) {
            return -1;
        }

        int l = haystack.length();
        char start = needle.charAt(0);
        for (int i = 0; i < l; i ++) {

            if (haystack.charAt(i) == start) {
                int process = i;
                int count = 0;
                while (process < l && haystack.charAt(process++) == needle.charAt(count++)) {
                    if (count == needle.length()) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
}
