package meta;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cafeteria {
    public static void main(String[] args) {

        long N = 10;
        long K = 1;
        int M = 2;
        long[] data = {2, 6};
        System.out.println(new Cafeteria().getMaxAdditionalDinersCount(N, K, M, data));
    }

    //1 [2] 3  4 5 [6] 7 8 9
    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        // Sort the existing diners' positions
        Arrays.sort(S);

        // Initialize the number of additional diners
        long additionalDiners = 0;

        // Handle the gap from seat 1 to the first occupied seat
        long firstGap = S[0] - 1;
        if (firstGap >= K) {
            additionalDiners += (firstGap) / (K + 1);
        }

        // Handle gaps between consecutive diners
        for (int i = 1; i < M; i++) {
            long gap = S[i] - S[i - 1] - 1;  // Number of seats between two diners
            if (gap >= 2 * K + 1) {
                additionalDiners += (gap - K) / (K + 1);
            }
        }

        // Handle the gap from the last occupied seat to seat N
        long lastGap = N - S[(int)M - 1];
        if (lastGap >= K) {
            additionalDiners += (lastGap) / (K + 1);
        }

        return additionalDiners;
    }

    // 1 [2] 3 4 5 [6] 7 8 9 10
}
