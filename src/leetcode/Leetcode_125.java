package leetcode;

public class Leetcode_125 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_125().isPalindrome("0p"));

    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toUpperCase(s.charAt(j)) != Character.toUpperCase(s.charAt(i))) {
                return false;
            }


            i++;
            j--;

        }
         return true;
    }


}
