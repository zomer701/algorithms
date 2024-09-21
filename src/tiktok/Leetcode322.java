package tiktok;

import java.util.HashMap;
import java.util.Map;

public class Leetcode322 {
    public static void main(String[] args) {
        int [] coins = {1, 2 , 5};
        int amount = 11;

        System.out.println(new Leetcode322().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        Map<Integer, Integer> memo = new HashMap<>();
       return  dp(coins, amount, memo);
    }

    private int dp(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int result = dp(coins, amount-coins[i], memo);
            if (result >= 0 && result < min) {
                min = 1 + result;
            }
        }

        memo.put(amount, min == Integer.MAX_VALUE ? -1 : min);

        return memo.get(amount);
    }
}
