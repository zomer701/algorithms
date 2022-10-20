package google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode_349 {
    public static void main(String[] args) {
        int[] data1 = {1,2,2,1};
        int[] data2  = {2,2};
        System.out.println(Arrays.toString(new Leetcode_349().intersection(data1, data2)));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>();
        for (int num: nums1) {
            numSet1.add(num);
        }

        Set<Integer> data = new HashSet<>();
        for (int num: nums2) {
            if (numSet1.contains(num)) {
                data.add(num);
            }
        }

        int [] result = new int[data.size()];
        int i = 0;
        for (Integer val: data) {
            result[i++] = val;
        }
        return result;
    }
}
