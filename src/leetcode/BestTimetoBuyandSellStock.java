package leetcode;

public class BestTimetoBuyandSellStock {
   //

    public static void main(String[] args) {
        int[] data = {1,2,4,2,5,7,2,4,9,0,9};

        System.out.println(new BestTimetoBuyandSellStock().maxProfit(data));
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int L = 0;
        int R = 1;
        int profit = 0;

        while (R < prices.length) {
            if (prices[L] < prices[R]) {
                int tempProfit =  prices[R] - prices[L];
                profit = Math.max(tempProfit, profit);
            } else {
                L++;
            }
            R++;

        }
        return profit;
    }
}
