package aws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_90 {

    public static void main(String[] args) {
        List<List<Integer>>  items = new Leetcode_90().subsetsWithDup(new int []{1,2,2});
        for (List<Integer> item: items) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> objects, int[] nums, int start) {
        list.add(new ArrayList<>(objects));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            objects.add(nums[i]);
            backtrack(list, objects, nums, i + 1);
            objects.remove(objects.size() - 1);
        }
    }
}
