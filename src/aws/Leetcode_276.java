package aws;

public class Leetcode_276 {
    public static void main(String[] args) {
        System.out.println(numWays(4, 2));
    }
    public static int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }

        int diff = k*(k-1);
        int same = k;

        for (int i = 3; i <= n; i++) {
            int oldDiff = diff;
            diff = (same + diff) * (k-1);
            same = oldDiff;
        }

        return same+diff;
    }
}
