package leetcode;

import java.util.Arrays;

public class HasGroupsSizeX {
    public static void main(String[] args) {
        int[] data = {1,1,2,2,2,2,2,9};
        System.out.println(new HasGroupsSizeX().hasGroupsSizeX(data));
    }

    public boolean hasGroupsSizeX(int[] deck) {

        if (deck.length <= 1) {
            return false;
        }

        int[] memo = new int[10000];
        for (int temp: deck) {
            memo[temp]++;
        }

        int group = 0;
        for (int mem: memo) {
            if (mem > 0) {
                if (group == 0) {
                    group = mem;
                } else {
                    group = gcd(group, mem);
                }
            }
        }

        return group >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
