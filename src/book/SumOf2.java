package book;

import google.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOf2 {
    public static void main(String[] args) {
        int[] array = {2,4,6,9,15};
        int target = 15;

        Set<Pair<Integer, Integer>> pairs = new SumOf2().defTwoSumOptimized(array, target);
        for (Pair pair: pairs) {
            System.out.println(pair.toString());
        }
    }

    private Set<Pair<Integer, Integer>> defTwoSumOptimized(int nums[], int k) {
        Set<Pair<Integer, Integer>> result = new HashSet<>();

        Map<Integer, Integer> mapper = new HashMap<>();
        int i = 0;
        for (int num: nums) {
            mapper.put(num, i++);
        }

        i = 0;
        while (i < nums.length) {
            int pivot = k - nums[i];

            Integer value = mapper.get(pivot);
            if (value != null && value != i) {
                result.add(new Pair<>(Math.max(pivot, nums[i]), Math.min(pivot, nums[i])));
            }
            i++;
        }

        return result;
    }
}
