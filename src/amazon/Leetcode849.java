package amazon;

public class Leetcode849 {
    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{0,1,1,1,0,0,1,0,0}));
    }

    public static int maxDistToClosest(int[] seats) {
        int result = -1;

        int first  = -1;
        int second  = -1;

        for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 1) {
                    if (first < 0) {
                        first = i;
                        result = first;
                        continue;
                    }

                    int mid = first+(i-first)/2;

                    if (((i-first)+1) % 2 == 0) {
                        mid = mid+1;
                    }
                    result = Math.max(result, i-mid);
                    second = first;
                    first = i;
                }

                if (i == seats.length-1 && seats[i] == 0) {
                   result = Math.max(result, seats.length-1-first);
                }

        }

        if (second < 0) {
            return Math.max(seats.length-1-first, first);
        }
        return result;
    }
}
