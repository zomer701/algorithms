package amazon;

public class Leetcode374 {

    public int guessNumber(int n) {
        int l = 0;
        int h = n;
        while (l < h) {
            int mid=l+(h-l)/2;
            int result = 1;//guess(mid);

            if (result == 0) {
                return mid;
            }

            if (result == -1) {
                h = mid-1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
