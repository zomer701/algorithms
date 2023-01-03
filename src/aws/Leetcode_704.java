package aws;

public class Leetcode_704 {
    public int search(int[] nums, int target) {
        return binS(nums, 0, nums.length - 1, target);
    }


    private int binS(int[] nums, int start , int end, int target)
    {
        while(start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        return -1;
    }
}
