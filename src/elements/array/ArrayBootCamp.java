package elements.array;

import java.util.Arrays;

/**
 * Deleting an element from an array entails moving all successive elements one over to the left to fill the vacated space.
 * For example, if the array is (2,3,5,7,9,11,13,17),
 * then deleting the element at index 4 results in the array (2,3,5,7,11,13,17,0).
 * */
public class ArrayBootCamp {
    public static void main(String[] args) {
        int[] data = {2,3,5,7,9,11,13,17};
        int target = 4;

        if (target >= 0 && data.length > target) {
            data[target] = 0;
            for (int i = target; i<data.length-1;i++){
                swap(data, i, i+1);
            }
        }

        System.out.println(Arrays.toString(data));
    }

    private static void swap(int data[], int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
