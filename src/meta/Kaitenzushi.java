package meta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Kaitenzushi {

    public static void main(String[] args) {
        int N = 6;
        int[] D = {1, 2, 3, 3, 2, 1};
        int K = 2;
        System.out.println(getMaximumEatenDishCount(N, D, K));
    }
    public static int getMaximumEatenDishCount(int N, int[] D, int K) {
        int result = 0;


        LinkedList<Integer> memo = new LinkedList<>();
        Set<Integer> memo2 = new HashSet<>();
        for (int i = 0; i < N; i++) {

            if (memo2.contains(D[i])) {
                continue;
            } else {

                memo.addFirst(D[i]);
                memo2.add(D[i]);

                int size = memo.size();
                while (size > K) {
                    memo2.remove(memo.removeLast());
                    size--;
                }
            }

            result++;
        }

        return result;
    }
}
