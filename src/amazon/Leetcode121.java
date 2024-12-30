package amazon;

public class Leetcode121 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            System.out.println(min);
            result = Math.max(result, prices[i]-min);
        }


        return result;
    }
}
