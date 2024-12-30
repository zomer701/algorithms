package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2420 {
    public static void main(String[] args) {
        int [] nums = {2,1,1,1,3,4,1};
        int k = 2;
       for (Integer val: goodIndices(nums, k)) {
         //  System.out.println(val);
       }
    }
    //todo memo

    public static List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n]; // number of elements that are just before the index i, which are in non-increasing order
        int[] suffix = new int[n]; // number of elements that are just after the index i, which are in non-decreasing order

        prefix[0] = 1;
        for (int i = 1 ; i < nums.length; i++) {
            if (nums[i-1] >= nums[i]) {
                prefix[i] = prefix[i-1] + 1;
            } else {
                prefix[i] = 1;
            }
        }

        suffix[nums.length-1] = 1;
        for (int i = nums.length-2 ; i >= 0; i--) {
            if (nums[i] <= nums[i+1]) {
                suffix[i] = suffix[i+1] + 1;
            } else {
                suffix[i] = 1;
            }
        }

        List<Integer> ans = new ArrayList<>(); // List to store all good indices

        for (int i = k ; i < nums.length-k; i++) {
            if (prefix[i-1] >=k && suffix[i+1] >= k) {
                ans.add(i);
            }
        }




        return ans;
    }
}
