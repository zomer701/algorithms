package aws;

public class Leetcode_1492 {
    public static void main(String[] args) {
        System.out.println(kthFactor2(7, 2));
    }

    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i ++) {

            if (n%i == 0) {
                count++;
                if (k == count) {
                    return i;
                }

            }
        }

        return -1;
    }

    public static int kthFactor2(int n, int k) {

        if (k == 1) {
            return 1;
        }

        int count = 1;

        for (int i = 2; i <= Math.floor(n/2); i ++) {

            if (n%i == 0) {
                count++;
                if (k == count) {
                    return i;
                }

            }
        }

        return -1;
    }
}
