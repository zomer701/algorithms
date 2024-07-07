package amazon;

import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> trig = new ArrayList<>();

        if (numRows == 0) {
            return trig;
        }

        if (numRows == 1) {
            trig.add(List.of(1));
            return trig;
        }

        trig.add(List.of(1));


        for (int i = 1; i < numRows; i++) {
            List<Integer> tempList = new ArrayList<>(i+1);
            tempList.add(1);

            List<Integer> prev = trig.get(i-1);

            for (int j = 1; j < i; j++) {
                tempList.add(prev.get(j) * prev.get(j-1));
            }

            tempList.add(1);
            trig.add(tempList);
        }

        return trig;
    }

}
