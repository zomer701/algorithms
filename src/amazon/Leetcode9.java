package amazon;

public class Leetcode9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        long result = 0;
        int temp = x;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        return  Integer.MAX_VALUE < result && result > Integer.MIN_VALUE ? false : temp == (int) result;
    }
}
