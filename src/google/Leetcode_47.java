package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode_47 {

    public static void main(String[] args) {
        int[] data = {1,1,3};

        for (List<Integer> values:  new Leetcode_47().permuteUnique(data)) {
            System.out.println(Arrays.toString(values.toArray()));
        }
    }
    HashSet <List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permute(new ArrayList<>(),nums, used);
        return new ArrayList<>(set);
    }

    public void permute(List<Integer> permutation, int []nums, boolean[] used){
        if(permutation.size() == nums.length){
            set.add(new ArrayList<>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                permutation.add(nums[i]);
                used[i] = true;
                permute(permutation, nums, used);
                permutation.remove(permutation.size()-1);
                used[i] =false;
            }

        }

    }


}
