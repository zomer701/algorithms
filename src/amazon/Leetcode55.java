package amazon;

import google.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[] {1,2,3}));
    }

    public static boolean canJump(int[] nums) {
        HashMap<Integer, Boolean> memo = new HashMap<>();


        if (jump(0, memo, nums)) {
            return true;
        }

        return false;
    }

    //2,3,1,1,4
    private static boolean jump(int index, HashMap<Integer, Boolean> memo, int[] nums) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }


        if (index + nums[index] >= nums.length-1) {
            return true;
        }

        for (int i = index+1 ; i <= Math.min(index + nums[index], nums.length); i++) {
            boolean result = jump(i, memo, nums);
            memo.put(i, result);

            if (result) {
                return true;
            }
        }

        memo.put(index, false);
        return false;
    }
}
