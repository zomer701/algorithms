package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_46 {

    List<List<Integer>> output = new ArrayList<>();

    public static void main(String[] args) {
        int[] data = {1,2,3};
        for (List<Integer> values: new Leetcode_46().permute(data)) {
            System.out.println(Arrays.toString(values.toArray()));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>());

        return output;
    }

    public void backtrack(int[] nums, LinkedList<Integer> curr) {
        if (curr.size() == nums.length) {
            output.add(new LinkedList(curr));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            backtrack(nums, curr);
            curr.removeLast();
        }
    }

}
