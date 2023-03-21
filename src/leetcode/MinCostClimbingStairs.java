package leetcode;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int [] nums = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(nums));
    }

    public int minCostClimbingStairs(int[] cost) {

        if (cost.length == 0) {
            return -1;
        }

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }


        int [] memo = new int[cost.length+1];

        for (int i = 2; i < memo.length; i++) {
            int oneStep = memo[i-1] + cost[i-1];
            int twoStep = memo[i-2] + cost[i-2];
            memo[i] = Math.min(oneStep, twoStep);
        }

        return memo[cost.length];
    }
}
