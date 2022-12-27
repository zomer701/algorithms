package aws;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode_347 {
    public static void main(String[] args) {
        int [] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(new Leetcode_347().topKFrequent(nums, k)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int num: nums) {
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }


        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(memo.entrySet());
        Collections.sort(list, Map.Entry.comparingByValue());

        int[] num = new int[k];
        for (int i = 0; i < k; i++) {
            num[i] = list.get(list.size() -1 - i).getKey();
        }

       return num;

    }
}
