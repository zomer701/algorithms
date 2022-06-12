package elements.array;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int[] data = {9,9, 7};
        System.out.println(Arrays.toString(new PlusOne().plusOneBook(data)));
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // move along the input array starting from the end
        for (int idx = n - 1; idx >= 0; --idx) {
            // set all the nines at the end of array to zeros
            if (digits[idx] == 9) {
                digits[idx] = 0;
            }
            // here we have the rightmost not-nine
            else {
                // increase this rightmost not-nine by 1
                digits[idx]++;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOneBook(int[] digits) {
        int n = digits.length - 1;
        digits[n] = digits[n] + 1;
        for (int idx = n ; idx > 0 && digits[idx] == 10; --idx) {
                    digits[idx] = 0;
                    digits[idx - 1] = digits[idx - 1] + 1;
        }

        if (digits[0] == 10) {
            digits = new int[digits.length+1];
            digits[0] = 1;
        }

        return digits;
    }
}
