package amazon;

import java.util.HashSet;
import java.util.Set;

public class Leetcode349 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> data = new HashSet<>();
        for (int num: nums1) {
            data.add(num);
        }

        Set<Integer> data2 = new HashSet<>();
        for (int num: nums2) {
            data2.add(num);
        }

        for (int num: data2) {
            if (!data.contains(num)) {
                data.remove(num);
            }
        }


        Set<Integer> memo = new HashSet<>();
        for (int num: data) {
            if (!data2.contains(num)) {
                memo.add(num);
            }
        }

        for (int num: memo) {
            if (data.contains(num)) {
                data.remove(num);
            }
        }



        int[] result = new int[data.size()];
        int index = 0;
        for (int val: data) {
            result[index++] = val;
        }
        return result;
    }
}
