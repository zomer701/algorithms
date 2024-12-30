package amazon;

public class Leetcode342 {
    public static void main(String[] args) {
        System.out.print(isPowerOfFour(64));
    }

    public static boolean isPowerOfFour(int n) {
        //n == 4x

        if (n <= 0) {
            return false;
        }

        while (n > 1) {
            if (n % 4 != 0) {
                return false;
            }

            n /= 4;
        }

        return true;
    }
}
