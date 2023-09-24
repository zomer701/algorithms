package meta;

import java.util.HashSet;

public class Cafeteria {
    public static void main(String[] args) {

        long N = 10;
        long K = 1;
        int M = 2;
        long[] data = {2, 6};
        System.out.println(new Cafeteria().getMaxAdditionalDinersCount(N, K, M, data));
    }

    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        long minSeats = K + 1;
        if (M == 0) {
            return N / minSeats + 1;
        }

        return 0L;
    }
}
