package trello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return false;

        }


        Map<Integer, List<Integer>> memo = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> data = memo.getOrDefault(nums[i], new ArrayList<Integer>());
            data.add(i);
            memo.put(nums[i], data);
        }

        for (Integer key: memo.keySet()) {
            if (memo.get(key).size() > 1) {
                for (int i = 0; i < memo.get(key).size() -1 ; i++) {
                    if (Math.abs(memo.get(key).get(i) - memo.get(key).get(i+1)) <= k) {
                        return true;
                    }
                }

            }
        }


        return false;
    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {

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
