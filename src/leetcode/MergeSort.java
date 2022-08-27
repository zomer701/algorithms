package leetcode;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int [] data = {11, 6, 3, 9, 14, 66, 2};

        mergeSort(data, 0, data.length-1);

        System.out.println(Arrays.toString(data));
    }

    private static void mergeSort(int[] data, int l, int u) {
        if (l < u) {
            int m = (u+l)/2;
            mergeSort(data, l, m);
            mergeSort(data, m+1, u);
            
            merge(data, l, m, u);
        }
    }

    private static void merge(int[] data, int l, int m, int u) {
        int n1 = m - l + 1;
        int n2 = u - m;

        int[] left = new int[n1];
        int[] right = new int[n1];

        for (int i = 0; i < n1; i++) {
            left[i] = data[l+i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = data[m+1+i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                data[k] = left[i];
                i++;
            } else {
                data[k] = right[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            data[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            data[k] = right[j];
            j++;
            k++;
        }


    }
}
