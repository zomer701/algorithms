package aws;

public class Leetcode_70 {
    public static void main(String[] args) {
        System.out.println(new Leetcode_70().climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] cache = new int[n+1];

        return climbStairs(n, cache);
    }

    public int climbStairs(int n, int[] cache) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (cache[n] > 0) {
            return cache[n];
        }

        cache[n] = climbStairs(n-1, cache) +
                climbStairs(n-2, cache);

        return cache[n];
    }
}
