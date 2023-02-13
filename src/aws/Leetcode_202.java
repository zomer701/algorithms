package aws;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_202 {
    public static void main(String[] args) {
        System.out.println(isHappy(7));
    }

    public static boolean isHappy(int n) {
        Set<Integer> memo = new HashSet<>();

        n = n < 10 ? n*n:n;

        while (n != 1 && !memo.contains(n)) {
            memo.add(n);

            int proceedN = n;
            int result = 0;
            while (proceedN > 0) {
                int value = proceedN % 10;
                result += value * value;
                proceedN = proceedN / 10;
            }
            n = result;
        }

        return n == 1;
    }
}
