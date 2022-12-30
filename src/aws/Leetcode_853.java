package aws;

import google.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leetcode_853 {
    public static void main(String[] args) {

        int target = 10;
        int [] position = {6,8};
        int [] speed = {3,2};

        System.out.println(new Leetcode_853().carFleet(target, position, speed));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair<Integer, Integer>> memo = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            memo.add(new Pair<>(position[i], i));
        }

        memo.sort(Comparator.comparing(Pair::getFirst));

        int result = 0;
        double maxtime = Integer.MIN_VALUE;
        for (int i = memo.size() - 1; i >= 0; i--) {
            double time = (double)(target-memo.get(i).getFirst()) / speed[memo.get(i).getSecond()];
                if (time > maxtime) {
                    result++;
                    maxtime = time;
                }
        }

       return result;
    }
}
