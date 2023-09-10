package meta;

public class Leetcod_268 {
    public static void main(String[] args) {
        int[] data = {3,0,1};
        System.out.println(new Leetcod_268().missingNumber(data));
    }
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int totalSum = n*(n+1)/2;
        int sum = 0;
        for(int i =0;i<n;i++){
            sum = sum+nums[i];
        }
        return totalSum - sum;
    }

}
