package aws;

public class Leetcode_121 {
    public static void main(String[] args) {
        int[] data = {7,1,5,3,6,4};
        System.out.println(new Leetcode_121().maxProfit(data));
    }

    public int maxProfit(int[] prices) {
        int small = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            int val = prices[i];
            small = Math.min(val, small);
            result = Math.max(result, val-small);
        }

        return result;
    }
}
