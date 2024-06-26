package amazon;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2470 {
    public static void main(String[] args) {
        int [] nums = {3};

        int k = 3;
        System.out.println(subarrayLCM(nums, k));
    }

    public static int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int curGCD = nums[i];
            if(curGCD == k) ans++;
            for(int j = i + 1; j < nums.length; j++){
                curGCD = lcm(nums[j], curGCD);
                if(curGCD == k) ans++;
                if (nums[j] > k) break;
            }
        }
        return ans;
    }

    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    public static int lcm(int a, int b){
        return (a / gcd(a, b)) * b;
    }

    private static int findPairs(int[] A){
        int size = A.length;
        if(size == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for(int num : A){
            set.add(num);
        }
        int count = 0;

        for(int i = 0 ; i < size ; i++){
            for(int j = i+1 ;  j < size ; j++){
                //we can optimize to not find lcm and gcd, since a * b = lcm(a,b) * gcd(a,b)
                // int gcd = findGCD(A[i],A[j]);
                // int lcm = findLCM(A[i],A[j],gcd);
                // int product = lcm * gcd;

                int product = A[i] * A[j];

                if(set.contains(product)){
                    count++;
                }
            }
        }

        return count;
    }

    private static int findLCM(int a , int b, int gcd){
        return a*b/gcd;
    }

    private static int findGCD(int a , int b){
        while(a > 0 && b > 0){
            if(a > b){
                a = a%b;
            }
            else{
                b = b%a;
            }
        }

        if(a == 0){
            return b;
        }
        else{
            return a;
        }
    }
}
