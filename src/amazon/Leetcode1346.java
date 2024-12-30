package amazon;

import java.util.HashSet;
import java.util.Set;

public class Leetcode1346 {
    public static void main(String[] args) {
        int [] data = {0,0};
        System.out.print(checkIfExist(data));
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int zeroCount = 0;
        for (int i : arr) {
            if (i == 0) {
                zeroCount++;
            }
            if (set.contains(i * 2) || set.contains(i/2) || (set.contains(0) && zeroCount>2)) {
                return true;
            }
            set.add(i);
        }

        return false;
    }

    public static boolean checkIfExist4(int[] arr) {
        Set<Double> memo = new HashSet<>();

        int count = 0;
        for (int ar: arr) {
            if (ar == 0) {
                count++;
            }
            memo.add((double) ar / 2);
        }

        for (int ar: arr) {
            if (memo.contains((double)ar)) {
                if ((ar == 0 && count <= 1)) {
                    continue;
                }
                return true;
            }
        }

        return false;
    }
}
