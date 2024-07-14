package amazon;

public class Leetcode344 {
    public static void main(String[] args) {
        char [] data = {'h','e','l','l','o'};
        reverseString(data);
    }

    public static void reverseString(char[] s) {

        int index = 0;
        for (char val: revert(String.valueOf(s)).toCharArray()) {
            s[index++] = val;
        }
    }

    static String revert(String s) {
        if (s.isEmpty()) {
            return "";
        }

        return revert(s.substring(1)) + s.charAt(0);
    }
}
