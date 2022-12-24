package aws;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_740 {
    public static void main(String[] args) {
        int [] data = {3,4,2};
        System.out.println(new Leetcode_740().deleteAndEarn(data));
    }

    public int deleteAndEarn(int[] nums) {
        int N = nums.length;

        if  (nums.length < 1) {
            return 0;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int val: nums) {
            count.put(val, count.getOrDefault(val, 0) + 1);
        }


        int[] memo = new int[N + 1];
        memo[0] = 0;

        for(int i = 1; i < N - 1; i++){
            // Same as the recursive solution.
            memo[i] = Math.max(memo[i - 1], ((i > 1) ? nums[i - 2] : 0) + nums[i] * count.get(nums[i]));
        }

        return memo[N];

    }

//    public int rob(int[] nums) {
//        int N = nums.length;
//
//        if  (nums.length < 1) {
//            return 0;
//        }
//
//        int[] memo = new int[N];
//        memo[N] = 0;
//        memo[N-1] = nums[N-1];
//
//        for (int i = N - 2; i >= 0; --i) {
//
//            // Same as the recursive solution.
//            memo[i] = Math.max(memo[i + 1], memo[i + 2] + nums[i]);
//        }
//
//        return memo[0];
//    }
}
