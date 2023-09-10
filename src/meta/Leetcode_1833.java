package meta;

import java.util.Arrays;

public class Leetcode_1833 {
    public static void main(String[] args) {
        int[] costs = {1,6,3,1,2,5};
        int coins = 20;
        System.out.println(new Leetcode_1833().maxIceCream(costs, coins));
    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int current = 0;
        for (int i = 0; i < costs.length; i++) {
            int tempCost = current;
            tempCost += costs[i];

            if (tempCost >= coins) {
                return (tempCost > coins ? i-1 : i) +1;
            }

            current = tempCost;

            if (i == costs.length-1 && coins > current) {
                return costs.length;
            }
        }

        return 0;
    }
}
