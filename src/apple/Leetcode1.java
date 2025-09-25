package apple;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();

        int index = 0;
        for (int num: nums) {
            if (memo.containsKey(num)) {
                return new int[]{memo.get(num), index};
            }
            memo.put(target - num, index++);
        }

        return new int[]{};
    }
}
