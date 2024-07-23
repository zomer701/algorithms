package amazon;

import java.util.Arrays;

public class Leetcode88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,4,5,6,0};
        int m = 5;
        int[] nums2 = {3};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    //1,2,3,0,0,0
    //1,5,6

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = 0;
        int num2Current = 0;
        int swap = m;

        while (count < m && count < n) {
            if (nums2[num2Current] < nums1[count] ) {
                swap(nums1, count, swap);
                nums1[count] = nums2[num2Current];
                swap++;
                num2Current++;
            }
            count++;
        }
        for (int i = num2Current; i < n ; i++) {
            nums1[swap++] = nums2[num2Current++];
        }

        count = 0;
        for (int i = 1; i < n+m ; i++) {
            if (nums1[i-1] > nums1[i]) {
                int c = nums1[i];
                swap(nums1, i-1, i);
                nums1[count++]=c;

            } else {
                nums1[count++] =nums1[i-1];
            }
        }

    }

    static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
