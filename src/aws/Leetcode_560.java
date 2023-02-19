package aws;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_560 {

    public static void main(String[] args) {
        int []  nums = {1,2,3, 5, 2};
        int k = 5;

        System.out.println(new Leetcode_560().subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int target) {
        int size = nums.length;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> head = new HashMap<>();
        head.put(sum, 1);
        for (int r = 0; r < size; r++) {
            sum += nums[r];
            int need = sum - target;
            count += head.getOrDefault(need, 0);
            head.put(sum, head.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
