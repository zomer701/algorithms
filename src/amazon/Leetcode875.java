package amazon;

public class Leetcode875 {
    public static void main(String[] args) {
//        int [] piles = {3,6,7,11};
//        int h = 8;
//        System.out.println(4 == minEatingSpeed(piles, h));



        int [] piles2 = {805306368,805306368,805306368};
        int h2 = 1000000000;
        System.out.println( minEatingSpeed(piles2, h2));
    }


    public static int minEatingSpeed(int[] piles, int h) {
        if (piles == null || h <= 0) {
            return -1;
        }

        int size = piles.length;

        if (size > h) {
            return -1;
        }

        int maxPile = getMaxPile(piles);

        int left = 1;
        int right = maxPile;

        while (left < right) {
            int mid = left+(right-left)/2;
            int value = checkEating(piles, mid);
            if (value <= h) {
                right = mid;
            } else {
                left = mid+1;
            }
        }

        return right;
    }

    private static int checkEating(int[] piles, int mid) {
        int result = 0;
        for (int pile: piles) {
            result+= (int) Math.ceil((double) pile /mid);
        }

        return result;
    }

    private static int getMaxPile(int[] piles) {
        if (piles.length == 1) {
            return piles[0];
        }

        int max = piles[0];

        for (int i = 1; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        return max;
    }
}
