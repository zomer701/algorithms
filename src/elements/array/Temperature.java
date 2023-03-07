package elements.array;

import java.util.Arrays;
import java.util.Stack;

public class Temperature {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(process(new int[]{1,2,3,90,80,50,90,80,110})));
        //1 1 1 5, 2, 1 , 2, 1, 0
        // 90 110

    }

    private static int[] process(int[] data) {
        Stack<int[]> memo = new Stack<>();

        memo.add(new int[]{data[data.length-1], data.length-1});
        data[data.length-1] = 0;

        for (int i = data.length-2; i >= 0 ; i--) {
            int current = data[i];

            int[] process = memo.peek();

            if (current < process[0]) {
                memo.add(new int[]{current, i});
                data[i] = process[1] - i;
                continue;
            }  else {
                while (!memo.isEmpty() && current >= memo.peek()[0]) {
                    memo.pop();
                }
                data[i] = memo.peek()[1] - i;
            }

            memo.add(new int[]{current, i});
        }


        return data;
    }
}
