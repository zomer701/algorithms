package amazon;

import java.util.HashMap;

public class Leetcode136 {
    public static void main(String[] args) {
        int[] data = {4,1,2,1,2};
        System.out.print(singleNumber(data));
    }

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }
}
