package amazon;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {
    public static void main(String[] args) {
        System.out.print(new Leetcode78().subsets(new int[] {1,2,3}));
    }

    List<List<Integer>> output = new ArrayList();


    public void backtrack(int first, ArrayList<Integer> curr, int[] nums, int k) {
        // If the combination is done
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i <  nums.length; ++i) {
            // Add i into the current combination
            curr.add(nums[i]);

            // Use the next integers to complete the combination
            backtrack(i + 1, curr, nums, k);

            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        for (int k = 0; k < nums.length + 1; k++) {
            backtrack(0, new ArrayList<Integer>(), nums, k);
        }
        return output;
    }
}
