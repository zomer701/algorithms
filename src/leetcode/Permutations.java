package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
    List<List<Integer>> output = new LinkedList();

    public static void main(String[] args) {
        int[] data = {1,2,3};
        for (List<Integer> list: new Permutations().permute(data)) {
            System.out.println();
            for (Integer val: list) {
                System.out.print(val);
                System.out.print(",");
            }
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
