package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode15 {
    public static void main(String[] args) {
        int[] data = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(data));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        Integer prev = null;
        int start = 0;
        for (int num: nums) {
            if (prev==null || prev != num) {
                List<List<Integer>> data = twoSum(nums, start++, -num);
                res.addAll(data);
            }

            prev = num;
        }


        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, int start, int value) {
        List<List<Integer>> res = new ArrayList<>();
        int l = start+1;
        int r = nums.length-1;
        while (l < r) {
            if (nums[l] + nums[r] == value) {
                res.add(List.of(nums[l], nums[r], -value));
                l++;
                r--;
            } else if (nums[l] + nums[r] > value) {
                r--;
            } else {
                l++;
            }
        }

        return res;
    }
}
