package meta;

public class RotaryLock {
    public static void main(String[] args) {
        int [] C = {9, 4, 4, 8};

        System.out.println(getMinCodeEntryTime(10, 4,  C));
    }


    public static long getMinCodeEntryTime(int N, int M, int[] C) {
        long result = 0L;
        int prev = 1;

        for (int step: C) {
            if (prev != step) {
                int nextStep = Math.abs(Math.min(step - prev, (N-step)+prev));
                result += nextStep;
                prev = step;
            }
        }

        return result;
    }

}
