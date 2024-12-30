package amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leetcode322A {
    public static void main(String[] args) {
        int [] coins = {1,2,3};
        int amount = 20;
        System.out.println(new Leetcode322A().coinChange(coins, amount));
    }

    int result = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        executeCoins(coins, new LinkedList(), amount);
        return !Integer.valueOf(result).equals(Integer.MAX_VALUE)  ? result : -1;
    }

    private void executeCoins(int[] coins, LinkedList<Integer> currentCoins, int amount) {

        if (amount == 0) {
            if (currentCoins.size() > 0) {
                result = Math.min(result, currentCoins.size());
            }
            return;
        }

        if (amount < 0) {
            return;
        }


        for(int coin: coins) {
            LinkedList coinsList = new LinkedList(currentCoins);
            coinsList.add(coin);
            executeCoins(coins, coinsList, amount-coin);
        }
    }
}
