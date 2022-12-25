package aws;

public class Leetcode_7 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_7().reverse(301L));
    }

    public int reverse(long x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }
}
