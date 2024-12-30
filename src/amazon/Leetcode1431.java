package amazon;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1431 {
    public static void main(String[] args) {
        int [] candies = {2,3,5,1,3};
        int extraCandies = 3;
        System.out.print(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int n = Integer.MIN_VALUE;

        for (int candy: candies) {
            n = Math.max(n, candy);
        }

        for (int candy: candies) {
            result.add(candy+extraCandies >= n);
        }
        return result;
    }
}
