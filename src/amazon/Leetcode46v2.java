package amazon;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46v2 {
    public static void main(String[] args) {
        int[] permute = new int []{1,2,3};
        for (List<Integer> val: new Leetcode46v2().permute(permute)) {
            System.out.print(val);
        }
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        backTracking(new ArrayList<>(), output, nums);
        return output;
    }

    private void backTracking(List<Integer> state, List<List<Integer>> output, int[] nums) {
        if (state.size() == 3) {
            output.add(new ArrayList<>(state));
        }

        for (int i = 0; i < nums.length; i++) {
            if (state.contains(nums[i])) {
                continue;
            }
            state.add(nums[i]);
            backTracking(state, output, nums);
            state.remove(state.size()-1);
        }
    }
}
