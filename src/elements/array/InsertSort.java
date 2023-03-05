package elements.array;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int [] data = {1, 2 , 8, 10, 3, 12, 4, 90 , 3};
        insertion_sort(data);
        System.out.println(Arrays.toString(data));
    }

    private static void insertion_sort(int[] items) {
        int i, j;
        int l = items.length;
        for (i = 1; i < l; i++) {
            j = i;
            while ((j > 0) && (items[j] < items[j - 1])) {
                swap(items,j,j - 1);
                j = j - i;
            }
        }
    }

    private static void swap(int data[], int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
