package meta;

import java.util.Arrays;

public class ScoreboardInference {
    public static void main(String[] args) {
        System.out.print(3 / 2 + (3 % 2));
    }

    public int getMinProblemCount(int N, int[] S) {
        // Write your code here
        Arrays.sort(S);

        int n = 0;

        if(S[S.length - 1] % 2 == 1) {

            n = S[S.length - 1] / 2 + 1;

        } else {
            n = S[S.length - 1] / 2;

            for(int i = 0; i < S.length; i++) {
                if(S[i] % 2 == 1) {
                    n++;
                    break;

                }

            }

        }

        return n;
    }
}
