package leetcode;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 1, 67, 20, 56, 34, 43, 90, 54, 8, 0};
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int lb, int ub) {
        int index;
        if (lb < ub) {
            index = partitionValue(arr, lb, ub);
            quickSort(arr, lb, index-1);
            quickSort(arr, index, ub);

        }
    }

    private static int partitionValue(int[] arr, int lb, int ub) {
        int pivot = arr[lb];
        int left = lb;
        int right = ub;

        while (left < right) {
            while (arr[left] <= pivot
                    && left < arr.length-1);
            left++;
            while (arr[right] > pivot
                    && right > 0);
            right--;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        int temp = arr[lb];
        arr[lb] = arr[right];
        arr[right] = temp;
        return right;
    }
}
