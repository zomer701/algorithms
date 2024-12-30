package meta;

public class StackStabilization {

    public static void main(String[] args) {
        int N = 5;
        int [] R = {2, 5, 3, 6, 5};

        System.out.print(getMinimumDeflatedDiscCount(N, R));
    }

    public static int getMinimumDeflatedDiscCount(int N, int[] R) {

        int result = 0;

        if (N == 1) {
            return 0;
        }

        for (int i = R.length-2; i >= 0 ; i --) {
            if (R[i] >= R[i+1]) {
                R[i] = R[i+1]-1;
                result++;
                if (R[i] <= 0) {
                    return -1;
                }
            }
        }

        return result;
    }

}
