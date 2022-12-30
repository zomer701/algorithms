package aws;

import google.Pair;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 100;
        System.out.println(new Leetcode_322().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> hash = new HashMap<>();
        queue.add(amount);
        hash.put(amount, 0);
        while (!queue.isEmpty()) {
            int change = queue.poll();
            int level = hash.get(change);
            for (int coin: coins) {
                if (coin <= change) {
                    int remain = change - coin;
                    if (remain == 0) {
                        return level + 1;
                    }
                    if (!hash.containsKey(remain)) {
                        queue.add(remain);
                        hash.put(remain, level + 1);
                    }
                }
            }
        }
        return -1;
    }
}
