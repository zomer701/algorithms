package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        Set<Integer> memo = new HashSet<>();
        int n = 2;

        while (n != 1 && !memo.contains(n)) {
            memo.add(n);
            n = getNext(n);
        }

        System.out.println(n == 1);
    }

    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }

        return totalSum;
    }
}
