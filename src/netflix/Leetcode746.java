package netflix;

public class Leetcode746 {
    public static void main(String[] args) {
        int [] cost = {10,15,20};

        System.out.println(minCostClimbingStairs(cost));
    }
    public static int minCostClimbingStairs(int[] nums) {
         int minimumCost[] = new int[nums.length + 1];

        for (int i = 2; i < minimumCost.length; i++) {
            int takeOneStep = minimumCost[i - 1] + nums[i - 1];
            int takeTwoSteps = minimumCost[i - 2] + nums[i - 2];
            minimumCost[i] = Math.min(takeOneStep, takeTwoSteps);
        }

        // The final element in minimumCost refers to the top floor
        return minimumCost[minimumCost.length - 1];
    }
}
