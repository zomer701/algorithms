package aws;

import java.util.Arrays;

public class Leetcode_88 {
    public static void main(String[] args) {
        int [] nums1 = new int [] {0};
        int m = 0;
        int [] nums2 = new int [] {1};
        int n = 1;

        new Leetcode_88().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] save = new int [nums1.length];

        int countN = 0;
        int countM = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (countM < m && countN < n) {
                save[i] = nums1[countM] <= nums2[countN] ? nums1[countM++] : nums2[countN++];
                continue;
            }

            if (countM < m) {
                save[i]=nums1[countM++];
                continue;
            }

            if (countN < n) {
                save[i]=nums2[countN++];
            }

        }


        int count = 0;
        for (int data: save) {
            nums1[count++] = data;
        }

    }
}
