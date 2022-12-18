package aws;

public class Leetcode_746 {
    public static void main(String[] args) {
        int [] data = {10,15,20, 12, 33};
        System.out.println(new Leetcode_746().minCost(data));
    }

    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        if (N < 1) {
            return 0;
        }

        int [] memo = new int[N+1];

       for (int i = 2; i < memo.length; i++) {
           int one = memo[i - 1] + cost[i - 1];
           int two = memo[i - 2] + cost[i - 2];
           memo[i] = Math.min(one, two);
       }


        return memo[memo.length-1];
    }

    public int minCost(int[] cost) {
        int N = cost.length;
        if (N < 1) {
            return 0;
        }

        int one = 1;
        int two = 1;

        for (int i = N - 1; i > 0; i--) {
            int temp = one;
            one = one + two;
            two = temp;
        }


        return one;
    }
}
