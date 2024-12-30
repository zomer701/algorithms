package amazon;

public class Leetcode58 {
    public static void main(String[] args) {
        System.out.print(lengthOfLastWord("   Hello World"));
    }

    public static int lengthOfLastWord2(String s) {
        // trim the trailing spaces
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ') {
            p--;
        }

        // compute the length of last word
        int length = 0;
        while (p >= 0 && s.charAt(p) != ' ') {
            p--;
            length++;
        }
        return length;
    }

    public static int lengthOfLastWord(String s) {
        int result = 0;

        int n = s.length()-1;

        while (n >= 0) {
            if (s.charAt(n) != ' ') {
                result++;
            } else {
                if (result > 0) {
                    return result;
                }
            }

            n--;
        }

        return result;
    }
}
