package netflix;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1770 {
    public static void main(String[] args) {
        int [] nums = {1,2};
        int [] multipliers = {3,1};

        System.out.println(new Leetcode1770().maximumScore(nums, multipliers));
    }

    public int maximumScore(int[] nums, int[] multipliers) {

        return back(0, nums.length-1, 0, nums, multipliers, new HashMap<>());
    }

    private int back(int left, int right, int index, int[] nums, int[] multipliers, Map<String, Integer> memo) {
        if (index==multipliers.length) {
            return 0;
        }

        if (memo.containsKey(left+"-"+right+"-"+multipliers[index])) {
            return memo.get(left+"-"+right+"-"+multipliers[index]);
        }

        int leftScore = back(left+1, right, index+1, nums, multipliers, memo) + nums[left] * multipliers[index];
        int rigthScore = back(left, right-1, index+1, nums, multipliers, memo) + nums[right] * multipliers[index];

        memo.put(left+"-"+right+"-"+multipliers[index], Math.max(leftScore, rigthScore));


        return Math.max(leftScore, rigthScore);
    }

}
