package amazon;

public class Leetcode125 {
    public static void main(String[] args) {
        System.out.print(isPalindrome2("race a car"));
    }

    public static boolean isPalindrome2(String s) {

        if (s.isEmpty() || s.length() == 1) {
            return true;
        }

        char left = s.charAt(0);
        char right = s.charAt(s.length()-1);

        if ((!Character.isLetterOrDigit(left) && !Character.isLetterOrDigit(right)) ||
                (Character.isLetterOrDigit(left) && Character.isLetterOrDigit(right) && Character.toUpperCase(left) == Character.toUpperCase(right))) {
            return isPalindrome2(s.substring(1, s.length()-1));
        }

        if (!Character.isLetterOrDigit(left)) {
            return isPalindrome2(s.substring(1));
        }

        if (!Character.isLetterOrDigit(right)) {
            return isPalindrome2(s.substring(0, s.length()-1));
        }

        return false;

    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }

            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }


        return true;
    }
}
