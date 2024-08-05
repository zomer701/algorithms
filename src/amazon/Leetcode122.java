package amazon;

public class Leetcode122 {
    public static void main(String[] args) {
        int [] prices = new int [] {1,2,3,4,5};
        System.out.print(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int profit = 0;


        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] < prices[i]) {
                profit += prices[i]-prices[i-1];
            }
        }

        return profit;
    }
}
