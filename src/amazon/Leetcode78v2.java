package amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode78v2 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(0, new LinkedList<Integer>(), nums, 0, output);
        return output;
    }

    public void backtrack(int first, LinkedList<Integer> curr, int[] nums, int k, List<List<Integer>> output) {
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
            if (k != 0) {
                return;
            }
        }

        for (int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i, curr, nums, k+1, output);
            curr.removeLast();
        }
    }

}
