package aws;

import java.util.HashSet;

public class Leetcode_41 {
    public static void main(String[] args) {
        int [] data = {1, 3, 6, 4, 1, 2};
        System.out.println(new Leetcode_41().firstMissingPositive(data));
    }

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        for (int i: nums) {
            unique.add(i);
        }

        int i = 1;
        while (true) {
            if (!unique.contains(i)) {
                return i;
            }

            i ++;
        }
    }
}
