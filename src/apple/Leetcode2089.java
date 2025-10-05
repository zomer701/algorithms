package apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode2089 {

    public static void main(String[] args) {
        int [] nums = {1};
        int target = 2;

        System.out.println(targetIndices(nums, target));
    }
    public static List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;


        while (left <= right) {
            int pivot = (right+left)/2;
            if (nums[pivot] == target) {
                return  collectResult(nums, target, pivot);
            }

            if (target > nums[pivot]) {
                left = pivot+1;
            }

            if (target < nums[pivot]) {
                right = pivot-1;
            }

        }

        return new ArrayList<>();
    }

    public static List<Integer> collectResult(int[] nums, int target, int center) {

        List<Integer> result = new ArrayList<>();
        result.add(center);

        int leftCenter = center-1;
        int rightCenter = center+1;

        while ((leftCenter >= 0 && nums[leftCenter] == target) || (rightCenter < nums.length && nums[rightCenter] == target)) {
            if (leftCenter >= 0 && nums[leftCenter] == target) {
                result.add(leftCenter);
            }

            if (rightCenter < nums.length && nums[rightCenter] == target) {
                result.add(rightCenter);
            }

            leftCenter--;
            rightCenter++;
        }

        Collections.sort(result);
        return result;
    }
}
