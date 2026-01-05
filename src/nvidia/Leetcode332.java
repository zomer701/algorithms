package nvidia;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Leetcode332 {
    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        Arrays.sort(coins);

        int[] coinsAmount = new int[max];
        Arrays.fill(coinsAmount, max);

        coinsAmount[0] = 0;

        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (a - c >= 0) {
                    coinsAmount[a] = Math.min(coinsAmount[a], coinsAmount[a - c] + 1);
                }
            }
        }

        return coinsAmount[amount] > amount ? -1 : coinsAmount[amount];
    }
}
