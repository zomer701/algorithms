package amazon;

public class CandyDistribution {

    public static int minCandies(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;

        int candies = 1; // Start with one candy for the first child
        int up = 0;      // Length of the increasing slope
        int down = 0;    // Length of the decreasing slope
        int peak = 0;    // Last peak position, to handle equal distribution

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // Increasing slope
                up++;
                peak = up;
                down = 0;
                candies += 1 + up;
            } else if (ratings[i] < ratings[i - 1]) {
                // Decreasing slope
                down++;
                up = 0;
                candies += 1 + down;
                // Adjust peak if down length >= peak
                if (down > peak) {
                    candies++;
                }
            } else {
                // Flat rating, reset streaks
                up = down = peak = 0;
                candies++;
            }
        }

        return candies;
    }
}
