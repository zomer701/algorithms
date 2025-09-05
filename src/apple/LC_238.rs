impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        let n = nums.len();
        let mut answer = vec![1; n];

        let mut prefix = 1;
        for i in 0..n {
            answer[i] = prefix;
            prefix = prefix * nums[i];
        } 

        let mut sufix = 1;
         for i in (0..n).rev() {
            answer[i] = answer[i] * sufix;
            sufix = nums[i] * sufix;
         }

         return answer;
    }
}
