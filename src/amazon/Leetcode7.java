package amazon;

public class Leetcode7 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(long x) {
        long result = 0;
        while (x != 0) {
            result = result*10 + x%10;
            x = x/10;
        }

        return Integer.MAX_VALUE < result && result > Integer.MIN_VALUE ? -1 : (int) result;
    }
}
