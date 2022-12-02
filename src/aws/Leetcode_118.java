package aws;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_118 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> trig = new ArrayList<>();
        trig.add(new ArrayList<>());
        trig.get(0).add(1);

        for (int rowNum = 1; rowNum< numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevrow = new ArrayList<>();

            row.add(1);

            for (int j = 1; j <rowNum; j++) {
                row.get(prevrow.get(j-1) + prevrow.get(j));
            }

            row.add(1);

            trig.add(row);
        }

        return trig;
    }

}
