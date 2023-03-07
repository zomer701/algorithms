package elements.array;

import java.util.Arrays;

public class RevertKElement {
    public static void main(String[] args) {
        int[] data = new int[]{1,2, 3, 46,44};
        //2 1 | 3 44 46
        process(data, 2);

        System.out.println(Arrays.toString(data));
    }

    private static void process(int[] data, int k) {
        invert(data, 0, k-1);
        invert(data, k, data.length-1);
        invert(data, 0, data.length-1);
    }

    private static void invert(int[] data, int start, int end) {
       while (start < end) {
           int temp = data[start];
           data[start] = data[end];
           data[end] =temp;

           start++;
           end--;
       }
    }
}
