package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOf3 {
    public static void main(String[] args) {
        int[] array = {-1,0,1,2,15};
        int target = 0;

        List<List<Integer>> pairs = new SumOf3().defThreeSumOptimized(array, target);
        for (List<Integer> pair: pairs) {
            System.out.println(pair.toString());
        }
    }

    private List<List<Integer>> defThreeSumOptimized(int nums[], int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int i = 0;
        while (i < nums.length) {
            int left = i + 1;
            int right = nums.length-1;
            int target = -nums[i];

            while (left < right) {
                int combination = nums[left] + nums[right];
                if (combination - target == 0) {
                    result.add(List.of(nums[left], nums[right], nums[i]));
                    left++;
                    right--;
                    continue;
                }

                if (combination < target) {
                    left++;
                    continue;
                }

                right--;
            }

            i++;
        }
            return result;
    }
}
