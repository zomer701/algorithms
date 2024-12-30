package meta;

import javax.management.DynamicMBean;

public class UniformIntegers {

    public static void main(String[] args) {
        System.out.println(countUniformIntegers(75, 300));
    }
    public static int countUniformIntegers(int A, int B) {
        int count = 0;

        // Loop through digits from 1 to 9 (since uniform numbers have repeating digits)
        for (int digit = 1; digit <= 9; digit++) {
            long uniformNumber = digit;

            // Keep generating uniform numbers by adding the same digit repeatedly
            while (uniformNumber <= B) {
                if (uniformNumber >= A) {
                    count++;
                }
                // Generate the next uniform number by appending the same digit
                uniformNumber = uniformNumber * 10 + digit;
            }
        }

        return count;
    }

//    int lowerBound = (int) Math.pow(10, getNumberOfDigits(number) - 1);
//    int upperBound = (int) Math.pow(10, getNumberOfDigits(number)) - 1;

    public static long getNumberOfDigits(long number) {
        return (long) Math.log10(number) + 1;
    }
}
