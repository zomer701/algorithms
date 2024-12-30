package trello;

public class Leetcode_643 {

    public static void main(String[] args) {
        int [] nums = {-1};
        int k = 1;

        System.out.println(findMaxAverage(nums, k));
    }
    public static double findMaxAverage(int[] nums, int k) {

        double max =  Integer.MIN_VALUE;

        double sum = 0;
        for (int j = 0; j < k; j++) {
            sum+=nums[j];
        }


        max = Math.max(sum, max);

        for (int i = 1; i+k-1 < nums.length; i++) {
            sum-=nums[i-1];
            sum+=nums[i+k-1];
            max = Math.max(sum, max);
        }


        return max/k;
    }
}
