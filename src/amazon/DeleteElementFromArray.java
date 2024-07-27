package amazon;

import java.util.Arrays;

public class DeleteElementFromArray {
    public static void main(String[] args) {
        int [] data = {2,3,5,7,9,11,7,1};

        System.out.println(Arrays.toString(deleteElement(data, 7)));
    }

    private static int[] deleteElement(int[] data, int k) {
        int current = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != k) {
                data[current++] = data[i];
            }
        }

        for (int i = current; i < data.length; i++) {
            data[i] = 0;
        }

        return data;

    }
}
