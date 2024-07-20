package amazon;

import java.util.Arrays;

public class Leetcode322 {
    public static void main(String[] args) {
        int [] coins = {2};
        int amount = 3;
        System.out.println(new Leetcode322().coinChange2(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int result = 0;
        int n = coins.length-1;

        Arrays.sort(coins);

        while (amount > 0 && n>0) {
            int current = coins[n];

            if (current > amount) {
                n--;
                continue;
            }
            amount-=current;
            result++;
        }


        return amount == 0 ? result : -1;
    }

    int result = Integer.MAX_VALUE;
    int[] coins;
    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        this.coins = coins;
        helper(amount, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    void helper(int amount, int dept) {
        if (amount < 0) {
            return;
        }

        if (result != Integer.MAX_VALUE &&  dept > result) {
            return;
        }

        if (amount == 0) {
            result = Math.min(dept, result);
            return;
        }

        for (int coin: coins) {
            helper(amount-coin, dept+1);
        }
    }


    public int coinChange3(int[] coins, int amount) {
        int max = amount+1;
        int[] memo = new int[max];
        Arrays.fill(memo, max);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++)   {
                if (coins[j] <= i) {
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }

        return memo[amount] > amount ? -1 : memo[amount];
    }
}
