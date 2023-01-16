package aws;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {

        int data [] = new int[] {1, 4, 7, 8 , 9, 3};
        System.out.println(search(data, 0));
    }

    private static int search(int [] array, int number) {
        Arrays.sort(array);
        int start = 0;
        int end = array.length -1;


        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == number) {
                return number;
            }

            if (array[mid] < number  ) {
                start = mid + 1;
            }
                end = mid - 1;
            }


        return -1;
    }
}
