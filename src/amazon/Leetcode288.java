package amazon;

import java.util.ArrayList;
import java.util.List;

public class Leetcode288 {
    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.print(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            return List.of(String.valueOf(nums[0]));
        }


        int prev = nums[0];
        int start = -1 ;
        for (int i = 1; i < nums.length; i++) {
            if (prev+1 == nums[i]) {
                if (start < 0) {
                    start = i-1;
                }
                prev = nums[i];
                continue;
            } else {
                if (start >= 0) {
                    result.add(nums[start] +"->"+ nums[i-1]);

                } else {
                    result.add(String.valueOf(nums[i-1]));
                }

                if (i == nums.length-1) {
                    result.add(String.valueOf(nums[i]));
                }
                start = -1;

            }
            prev = nums[i];

        }
        if (start >= 0) {
            result.add(nums[start] + "->" + nums[nums.length-1]);
        }

        return result;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            // Keep iterating until the next element is one more than the current element.
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                ranges.add(start + "->" + nums[i]);
            } else {
                ranges.add(String.valueOf(start));
            }
        }

        return ranges;
    }
}
