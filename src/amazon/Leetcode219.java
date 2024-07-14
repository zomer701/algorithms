package amazon;

import java.util.HashMap;
import java.util.Map;

public class Leetcode219 {
    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return false;

        }


        Map<Integer, Integer> memo = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(memo.containsKey(nums[i])){
                int temp = memo.get(nums[i]);
                if(Math.abs(temp - i) <= k){
                    return true;
                }
            }
            memo.put(nums[i], i);
        }



        return false;
    }
}
