package trello;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_643 {

    public static void main(String[] args) {
        int [] nums = {1,12,-5,-6,50,3};
        int k = 4;

        System.out.println(findMaxAverage(nums, k));
    }
    public static double findMaxAverage(int[] nums, int k) {

        int result = 0;
        int count = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i];
            count++;

            if (count == k) {
                ans = result > ans ? result : ans;
            }

            if (count > k) {
                result -= nums[i-k];
                ans = result > ans ? result : ans;
            }


        }

        return (double) ans/k;
    }
}
