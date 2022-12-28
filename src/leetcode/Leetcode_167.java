package leetcode;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode_167 {
    public static void main(String[] args) {

        int[] data = {2,3,4};

         System.out.println(Arrays.toString(twoSum(data, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];

        while (start < end) {
            if (nums[start]+nums[end] == target) {
                result[0]=start+1;
                result[1]=end+1;
                return result;
            }

            if (nums[start]+nums[end] > target) {
                end--;
                continue;
            }

            if (nums[start]+nums[end] < target) {
                start++;
                continue;
            }

            start++;
            end--;
        }

        return result;
    }
}
