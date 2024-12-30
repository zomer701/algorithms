package amazon;

public class Leetcode367 {
    public static void main(String[] args) {
        System.out.print(isPerfectSquare(257));
    }

    public static boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;


        while (left < right) {
            int mid = left+(right-left)/2;

            int sql = mid*mid;
            if (sql == num) {
                return true;
            }

            if (sql < num) {
                left = mid +1;
            } else {
                right = mid;
            }
        }

        return  false;
    }
}
