package aws;

public class Leetcode_122 {
    public static void main(String[] args) {
        int[] data = {7,1,5,3,6,4};
        System.out.println(new Leetcode_122().maxProfit(data));
    }

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
