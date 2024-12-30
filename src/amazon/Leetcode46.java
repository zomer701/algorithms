package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode46 {

    public static void main(String[] args) {
        for (List<Integer> list: permute(new int[]{1,2,3})) {
            System.out.println(list);
        }
    }
    static List<List<Integer>> output = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>());

        return output;
    }

    public static void backtrack(int[] nums, LinkedList<Integer> curr) {
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
