impl Solution {
    pub fn max_profit(prices: Vec<i32>) -> i32 {
        if (prices.is_empty()) {
            return 0; 
        }

        if (prices.len() == 1) {
            return prices[0]
        }

        let mut min_value = prices[0];
        let mut result = 0;
        
        for i in 1..prices.len() {
            min_value = min_value.min(prices[i]);
            result = result.max(prices[i]-min_value);
        }

        return result;
    }
}
