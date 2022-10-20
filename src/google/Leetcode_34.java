package google;

import java.util.Arrays;

public class Leetcode_34 {
    public static void main(String[] args) {
        int [] data = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(new Leetcode_34().searchRange(data, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int first = find(nums, target, true);

        if (first == -1) {
            return new int[]{-1, -1};
        }

        int last = find(nums, target, false);

        return new int[]{first, last};
    }

    private int find(int[] nums, int target, boolean b) {
        int leng = nums.length;
        int begin = 0;
        int end = leng - 1;

        while (begin <= end) {
            int mid = (begin + end) / 2;

            if (nums[mid] == target) {
                if (b) {
                    if (mid == begin || nums[mid - 1] != target) {
                        return mid;
                    }

                    end = mid - 1;
                } else {
                    if (mid == end || nums[mid + 1] != target) {
                        return mid;
                    }
                    begin = mid + 1;
                }
            } else {
                if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            }

        }

        return -1;
    }


}
