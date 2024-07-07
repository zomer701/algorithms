package amazon;

public class Leetcode704 {
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
