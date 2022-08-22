package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode_202 {

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    private static boolean isHappy(int n) {
        Set<Integer> memo = new HashSet<>();
        while (n != 1 && !memo.contains(n)) {
            memo.add(n);
             n = getNext(n);
        }

        return n == 1;
    }

    static int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int val =  n % 10;
            n = n/10;
            total += val*val;
        }

        return total;
    }
}
