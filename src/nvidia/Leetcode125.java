package nvidia;

public class Leetcode125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length()-1;


        while (start < end) {
            char currentStart = s.charAt(start);
            char currentEnd = s.charAt(end);

            if (!Character.isLetterOrDigit(currentStart)) {
                start++;
                continue;
            }

            if (!Character.isLetterOrDigit(currentEnd)) {
                end--;
                continue;
            }

            if (Character.isLetterOrDigit(currentStart) && Character.isLetterOrDigit(currentEnd)
                    && Character.toLowerCase(currentEnd) != Character.toLowerCase(currentStart)) {
                return false;
            }

            end--;
            start++;
        }

        return true;
    }
}
