package amazon;

public class MergeSort {
    public static void main(String[] args) {

    }

    public static void mergeSort(int []data, int start, int end) {
        if (start < end) {
            int mid = start + (start-end)/2;
            mergeSort(data, start, mid);
            mergeSort(data, mid+1, end);
            merge(data, start, mid, end);
        }
    }

    private static void merge(int[] data, int start, int mid, int end) {
        int [] temp = new int [end-start+1];

        int i = start;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (data[i] <= data[j]) {
                temp[k] = data[i];
                i++;
                k++;
            } else {
                temp[k] = data[j];
                j++;
                k++;
            }
        }

        while (i <= mid) {
            temp[k] = data[i];
            k++;
            i++;
        }

        while (j <= end) {
            temp[k] = data[j];
            k++;
            j++;
        }

        for (i = start; i <=end; i++) {
            data[i] = temp[i-start];
        }
    }
}
