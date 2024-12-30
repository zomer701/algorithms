package trello;

import java.util.Arrays;

public class PrefixSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(sum(array)));
    }

    static int[] sum(int[] data) {
        if (data == null || data.length == 0) {
            return new int[0];
        }

        for (int i = 1 ; i < data.length; i++) {
            int current = data[i];
            data[i] = data[i-1] + current;
        }

        return data;
    }
}
