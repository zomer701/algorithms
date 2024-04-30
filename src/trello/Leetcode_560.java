package trello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_560 {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int target) {
        int count = 0;

       List<Integer> memo = new ArrayList<>();
        memo.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            List<Integer> currentMemo = new ArrayList<>();
            currentMemo.add(current);
            for (int value: memo) {
                currentMemo.add(current+value);
            }

            memo.addAll(currentMemo);
        }

        for (int data: memo) {
            if (target == data) {
               count++;
            }
        }

        return count;
    }
}
