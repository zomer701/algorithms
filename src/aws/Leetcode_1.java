package aws;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> data = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length - 1 && nums.length > 1; i++)
        {
            data.put(target-nums[i], i);

            if (data.containsKey(nums[i+1]))
            {
                result[0] = data.get(nums[i+1]);
                result[1] = i+1;

                return result;
            }

        }

        return result;
    }
}
