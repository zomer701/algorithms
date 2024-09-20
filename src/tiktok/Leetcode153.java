package tiktok;

import java.util.Arrays;

public class Leetcode153 {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        findMin(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int findMin(int[] arr) {

        int n = arr.length;

        mergeSort(arr, 0, n - 1);
        return arr[0];
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int [] L = new int[n1];
        int [] M = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[low + i];

        for (int i = 0; i < n2; i++)
            M[i] = arr[mid + i + 1];

        int i, j, k;
        i = 0;
        j = 0;
        k = low;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

}
